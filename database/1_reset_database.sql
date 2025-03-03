-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA IF EXISTS lend CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA lend
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA lend TO postgres;
GRANT ALL ON SCHEMA lend TO PUBLIC;