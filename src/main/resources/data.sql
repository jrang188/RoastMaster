CREATE TABLE Coffee
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    roaster      VARCHAR(255),
    origin       VARCHAR(255),
    originType   VARCHAR(255),
    region       VARCHAR(255),
    producer     VARCHAR(255),
    variety      VARCHAR(255),
    altitudeMASL INT,
    process      VARCHAR(255),
    caffeine     VARCHAR(255),
    roastLevel   VARCHAR(255),
    quantity     INT,
    price DOUBLE,
    currency     VARCHAR(10)
);

CREATE TABLE brew_methods
(
    coffee_id   BIGINT,
    brew_method VARCHAR(255),
    PRIMARY KEY (coffee_id, brew_method),
    FOREIGN KEY (coffee_id) REFERENCES Coffee (id) ON DELETE CASCADE
);

CREATE TABLE tasting_notes
(
    coffee_id    BIGINT,
    tasting_note VARCHAR(255),
    PRIMARY KEY (coffee_id, tasting_note),
    FOREIGN KEY (coffee_id) REFERENCES Coffee (id) ON DELETE CASCADE
);
