package io.github.lorensfs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.lorensfs.objects.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RestApiRequest {

    //@PostMapping("/register") - @RequestBody User user
    public boolean register(User user) {
        try {
            Gson gson = new Gson();
            String jsonRequest = gson.toJson(user);
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/user/register"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

            return Boolean.parseBoolean(postResponse.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@GetMapping("/login") - @RequestParam String email, @RequestParam String password
    public boolean login(String email, String password) {
        try {
            String uri = String.format("http://localhost:8080/user/login?email=%s&password=%s",
                    URLEncoder.encode(email, StandardCharsets.UTF_8),
                    URLEncoder.encode(password, StandardCharsets.UTF_8));

            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            return Boolean.parseBoolean(getResponse.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@GetMapping("/getUserId") - @RequestParam String email, @RequestParam String password
    public long getUserId(String email, String password) {
        try {
            String uri = String.format("http://localhost:8080/user/getUserId?email=%s&password=%s",
                    URLEncoder.encode(email, StandardCharsets.UTF_8),
                    URLEncoder.encode(password, StandardCharsets.UTF_8));

            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            return Long.parseLong(getResponse.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@GetMapping("/searchRestaurants") - @RequestParam String keyword
    public List<Restaurant> searchRestaurants(String keyword) {
        try {
            String uri = String.format("http://localhost:8080/user/searchRestaurants?keyword=%s",
                    URLEncoder.encode(keyword, StandardCharsets.UTF_8));

            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            if (getResponse.statusCode() == 404) {
                throw new RuntimeException("Endpoint not found: " + uri);
            }

            Gson gson = new Gson();
            Type restaurantListType = new TypeToken<List<Restaurant>>() {
            }.getType();
            return gson.fromJson(getResponse.body(), restaurantListType);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@GetMapping("/listRestaurants")
    public List<Restaurant> listRestaurants() {
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/user/listRestaurants"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            // Send the request and get the response
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            Type restaurantListType = new TypeToken<List<Restaurant>>() {
            }.getType();
            return gson.fromJson(getResponse.body(), restaurantListType);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@GetMapping("/restaurant/{restaurantId}/menu") - @PathVariable Long restaurantId
    public List<MenuItem> getRestaurantMenu(Long restaurantId) {
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/user/restaurant/" + restaurantId + "/menu"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            Type menuItemListType = new TypeToken<List<MenuItem>>() {
            }.getType();
            return gson.fromJson(getResponse.body(), menuItemListType);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@PostMapping("/placeOrder") - @RequestBody List<OrderItem> items, @RequestParam Long userId, @RequestParam Long restaurantId
    public OrderModel placeOrder(List<OrderItem> items, Long userId, Long restaurantId) {
        try {
            Gson gson = new Gson();
            String jsonRequest = gson.toJson(items);

            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/user/placeOrder?userId=" + userId + "&restaurantId=" + restaurantId))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(postResponse.body(), OrderModel.class);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@GetMapping("/{userId}/orders") - @PathVariable Long userId
    public List<OrderModel> getOrdersById(Long userId) {
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/user/" + userId + "/orders"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();


            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            Type orderListType = new TypeToken<List<OrderModel>>() {
            }.getType();
            return gson.fromJson(getResponse.body(), orderListType);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@PatchMapping("/{orderId}/status/confirmed") - @PathVariable Long orderId
    public void acceptOrder(Long orderId) {
        try {
            HttpRequest patchRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/restaurant/" + orderId + "/status/confirmed"))
                    .header("Content-Type", "application/json")
                    .method("PATCH", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            httpClient.send(patchRequest, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@PatchMapping("/{orderId}/status/canceled") - @PathVariable Long orderId
    public void rejectOrder(Long orderId) {
        try {
            HttpRequest patchRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/restaurant/" + orderId + "/status/canceled"))
                    .header("Content-Type", "application/json")
                    .method("PATCH", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            httpClient.send(patchRequest, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@PatchMapping("/{orderId}/status/preparing") - @PathVariable Long orderId
    public void preparingOrder(Long orderId) {
        try {
            HttpRequest patchRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/restaurant/" + orderId + "/status/preparing"))
                    .header("Content-Type", "application/json")
                    .method("PATCH", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            httpClient.send(patchRequest, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@PatchMapping("/{orderId}/status/delivered") - @PathVariable Long orderId
    public void deliveredOrder(Long orderId) {
        try {
            HttpRequest patchRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/restaurant/" + orderId + "/status/delivered"))
                    .header("Content-Type", "application/json")
                    .method("PATCH", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            httpClient.send(patchRequest, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@GetMapping("{restaurantId}/orders") - @PathVariable Long restaurantId
    public List<OrderModel> getOrdersOfRestaurant(Long restaurantId) {
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/restaurant/" + restaurantId + "/orders"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            Type orderListType = new TypeToken<List<OrderModel>>() {
            }.getType();
            return gson.fromJson(getResponse.body(), orderListType);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
