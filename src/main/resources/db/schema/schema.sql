DROP SEQUENCE IF EXISTS "hibernate_sequence" CASCADE;
CREATE SEQUENCE "hibernate_sequence";

DROP TABLE IF EXISTS "audit" CASCADE;
DROP TYPE IF EXISTS "action" CASCADE;

CREATE TYPE "action" AS ENUM (
  'CREATE',
  'UPDATE',
  'DELETE'
);

CREATE CAST (CHARACTER VARYING as "action") WITH INOUT AS IMPLICIT;


CREATE TABLE "audit" (
    "id" SERIAL PRIMARY KEY,
    "owner" varchar,
    "code" varchar,
    "action" action,
    "message" varchar,
    "_user" varchar
)