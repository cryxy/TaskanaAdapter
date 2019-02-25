CREATE SCHEMA IF NOT EXISTS %schemaName%;

SET search_path TO %schemaName%;

CREATE TABLE TCA_SCHEMA_VERSION(
        ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
        VERSION VARCHAR(255) NOT NULL,
        CREATED TIMESTAMP NOT NULL,
        PRIMARY KEY (ID)
);

INSERT INTO TCA_SCHEMA_VERSION (VERSION, CREATED) VALUES ('1.0.4', CURRENT_TIMESTAMP);


CREATE TABLE IF NOT EXISTS TASKS(
        ID VARCHAR(64) NOT NULL,
        CREATED TIMESTAMP NOT NULL,
        COMPLETED TIMESTAMP,
        SYSTEM_URL VARCHAR(1024) NOT NULL,
        PRIMARY KEY (ID)
);

CREATE TABLE QUERY_HISTORY(
        ID VARCHAR(64) NOT NULL,
        QUERY_TIMESTAMP TIMESTAMP NOT NULL,
        AGENT_TYPE VARCHAR(32) NOT NULL,
        SYSTEM_URL VARCHAR(1024) NOT NULL,
        PRIMARY KEY (ID)
);

