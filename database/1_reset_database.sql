-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA IF EXISTS lend36back CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA lend36back
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA lend36back TO postgres;
GRANT ALL ON SCHEMA lend36back TO PUBLIC;