CREATE SCHEMA ESHOP_DESIGN_PATTERNS;

DROP TABLE IF EXISTS ESHOP_DESIGN_PATTERNS.TBUSER;
DROP TABLE IF EXISTS ESHOP_DESIGN_PATTERNS.TBUSERPROFILE;
DROP TABLE IF EXISTS ESHOP_DESIGN_PATTERNS.TBADDRESS;

CREATE TABLE IF NOT EXISTS ESHOP_DESIGN_PATTERNS.TBUSER (
    USER_ID BIGINT NOT NULL,
    EMAIL VARCHAR(100) UNIQUE NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL,
    DISCRIMINATOR VARCHAR(1)
);

CREATE TABLE IF NOT EXISTS ESHOP_DESIGN_PATTERNS.TBUSERPROFILE(
    USER_ID BIGINT NOT NULL,
    FIRST_NAME VARCHAR(50) NOT NULL,
    LAST_NAME VARCHAR(50) NOT NULL,
    PHONE_NO VARCHAR(20) NOT NULL,
    DATE_ADDED DATE NOT NULL,
    DATE_LAST_MODIFIED DATE,
    DISCRIMINATOR VARCHAR(1)
);

CREATE TABLE IF NOT EXISTS ESHOP_DESIGN_PATTERNS.TBADDRESS(
    ADDRESS_ID BIGINT NOT NULL,
    USER_ID BIGINT NOT NULL,
    STREET_NAME VARCHAR(50) NOT NULL,
    STREET_NUMBER VARCHAR(50) NOT NULL,
    POSTAL_CODE VARCHAR(50) NOT NULL,
    CITY VARCHAR(50) NOT NULL,
    COUNTRY VARCHAR(50) NOT NULL,
    DISCRIMINATOR VARCHAR(1)
);

-- PKs
ALTER TABLE ESHOP_DESIGN_PATTERNS.TBUSER ADD CONSTRAINT PKTBUSER PRIMARY KEY(USER_ID);
ALTER TABLE ESHOP_DESIGN_PATTERNS.TBUSERPROFILE ADD CONSTRAINT PKTBUSERPROFILE PRIMARY KEY(USER_ID);
ALTER TABLE ESHOP_DESIGN_PATTERNS.TBADDRESS ADD CONSTRAINT PKTBADDRESS PRIMARY KEY(ADDRESS_ID);

-- FKs
ALTER TABLE ESHOP_DESIGN_PATTERNS.TBUSERPROFILE ADD CONSTRAINT FKUSERPROFILEUSER FOREIGN KEY(USER_ID) REFERENCES ESHOP_DESIGN_PATTERNS.TBUSER(USER_ID) ON DELETE CASCADE;
ALTER TABLE ESHOP_DESIGN_PATTERNS.TBADDRESS ADD CONSTRAINT FKADDRESSUSERPROFILE FOREIGN KEY(USER_ID) REFERENCES ESHOP_DESIGN_PATTERNS.TBUSERPROFILE(USER_ID) ON DELETE CASCADE;
