CREATE DATABASE figures_funko;

CREATE TABLE
    figures_funko.funkos (
        funko_name VARCHAR(20) NOT NULL PRIMARY KEY,
        description VARCHAR(100) NOT NULL,
        vaulted boolean DEFAULT FALSE NOT NULL
    );

INSERT INTO
    figures_funko.funkos (funko_name, description, vaulted)
VALUES
    ('Superman', 'Superman action figure', FALSE),
    ('Batman', 'Batman action figure', FALSE),
    (
        'WonderWoman',
        'Wonder Woman action figure',
        FALSE
    ),
    ('SpiderMan', 'Spider-Man action figure', FALSE),
    ('IronMan', 'Iron Man action figure', FALSE);

-- Let's say we gotta put one at vault (IronMan)
UPDATE figures_funko.funkos
SET
    vaulted = TRUE
WHERE
    funko_name = 'IronMan';

-- Verify data
SELECT
    *
FROM
    figures_funko.funkos
ORDER BY
    funko_name;