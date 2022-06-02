--------------------------------------------------------
--  File created - Thursday-June-02-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table LANGUAGES
--------------------------------------------------------

CREATE TABLE "RM92270"."LANGUAGES" (
    "ID" NUMBER(*, 0),
    "DESCRIPTION" VARCHAR2(200),
    "AT_CREATE" TIMESTAMP (6),
    "AT_UPDATE" TIMESTAMP (6)
) 


--------------------------------------------------------
--  DDL for Table TYPE_FOODCONSUMED
--------------------------------------------------------

CREATE TABLE "RM92270"."TYPE_FOODCONSUMED" (
    "ID" NUMBER(*, 0),
    "DESCRIPTION" VARCHAR2(200),
    "VALUE_CALORIE" NUMBER(18, 3),
    "AT_CREATE" TIMESTAMP (6),
    "AT_UPDATE" TIMESTAMP (6)
) 

--------------------------------------------------------
--  DDL for Table TYPE_PHYACTIVITY
--------------------------------------------------------

CREATE TABLE "RM92270"."TYPE_PHYACTIVITY" (
    "ID" NUMBER(*, 0),
    "DESCRIPTION" VARCHAR2(200),
    "VALUE_CALORIE" NUMBER(18, 3),
    "AT_CREATE" TIMESTAMP (6),
    "AT_UPDATE" TIMESTAMP (6)
) 

--------------------------------------------------------
--  DDL for Table USER_ADDRESS
--------------------------------------------------------

CREATE TABLE "RM92270"."USER_ADDRESS" (
    "ID" NUMBER(*, 0),
    "USER_ID" NUMBER(*, 0),
    "ADDRESS" VARCHAR2(200),
    "ADDRESS_NR" NUMBER(*, 0),
    "DISTRICT" VARCHAR2(200),
    "CITY" VARCHAR2(200),
    "STATE" VARCHAR2(200),
    "UNIT" VARCHAR2(2),
    "ZIP_CODE" VARCHAR2(20),
    "COMPLEMENT" VARCHAR2(200),
    "AT_CREATE" TIMESTAMP (6),
    "AT_UPDATE" TIMESTAMP (6)
) 

--------------------------------------------------------
--  DDL for Table USER_ALERTS
--------------------------------------------------------

CREATE TABLE "RM92270"."USER_ALERTS" (
    "ID" NUMBER(*, 0),
    "USER_ID" NUMBER(*, 0),
    "HEARTBEATS_MAX" NUMBER(18, 3),
    "HEARTBEATS_MIN" NUMBER(18, 3)
) 

--------------------------------------------------------
--  DDL for Table USER_BLOODPRESSURE
--------------------------------------------------------

CREATE TABLE "RM92270"."USER_BLOODPRESSURE" (
    "ID" NUMBER(*, 0),
    "USER_ID" NUMBER(*, 0),
    "VALUE_BEATS" NUMBER(*, 3),
    "AT_CREATE" TIMESTAMP (6),
    "AT_UPDATE" TIMESTAMP (6),
    "VALUE_MIN" NUMBER,
    "VALUE_MAX" NUMBER
) 

--------------------------------------------------------
--  DDL for Table USER_FOODCONSUMED
--------------------------------------------------------

CREATE TABLE "RM92270"."USER_FOODCONSUMED" (
    "ID" NUMBER(*, 0),
    "TYPE_FOODCONSUMEDID" NUMBER(*, 0),
    "USER_ID" NUMBER(*, 0),
    "QTDE" NUMBER(*, 0),
    "VALUE_CALORIE" NUMBER(18, 3),
    "AT_CREATE" TIMESTAMP (6),
    "AT_UPDATE" TIMESTAMP (6)
) 

--------------------------------------------------------
--  DDL for Table USER_HEARTBEATS
--------------------------------------------------------

CREATE TABLE "RM92270"."USER_HEARTBEATS" (
    "ID" NUMBER(*, 0),
    "USER_ID" NUMBER(*, 0),
    "VALUE" NUMBER(18, 3),
    "AT_CREATE" TIMESTAMP (6),
    "AT_UPDATE" TIMESTAMP (6)
) 

--------------------------------------------------------
--  DDL for Table USER_PHYSICALACTIVITY
--------------------------------------------------------

CREATE TABLE "RM92270"."USER_PHYSICALACTIVITY" (
    "ID" NUMBER(*, 0),
    "USER_ID" NUMBER(*, 0),
    "TYPE_PHYACTIVITYID" NUMBER(*, 0),
    "TIME_ACTIVITYMINUTE" NUMBER(*, 0),
    "VALUE_CALORIE" NUMBER(18, 3),
    "AT_CREATE" TIMESTAMP (6),
    "AT_UPDATE" TIMESTAMP (6)
) 

--------------------------------------------------------
--  DDL for Table USER_PROFILE
--------------------------------------------------------

CREATE TABLE "RM92270"."USER_PROFILE" (
    "USER_ID" NUMBER(*, 0),
    "LANGUAGES_ID" NUMBER(*, 0),
    "AT_CREATE" TIMESTAMP (6),
    "AT_UPDATE" TIMESTAMP (6)
) 

--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

CREATE TABLE "RM92270"."USERS" (
    "ID" NUMBER(*, 0),
    "MAIL" VARCHAR2(200),
    "NAME" VARCHAR2(200),
    "PHONE_MOBILE" VARCHAR2(20),
    "BIRTH_DATE" DATE,
    "VERIFY_MAIL" NUMBER(*, 0),
    "AT_CREATE" TIMESTAMP (6) WITH TIME ZONE,
    "AT_UPDATE" TIMESTAMP (6) WITH TIME ZONE,
    "AT_LOGEED" TIMESTAMP (6) WITH TIME ZONE,
    "ACTIVE" NUMBER(*, 0),
    "PASSWORD" VARCHAR2(2000)
) 

REM INSERTING into RM92270.LANGUAGES
SET DEFINE OFF;

REM INSERTING into RM92270.TYPE_FOODCONSUMED
SET DEFINE OFF;

Insert into RM92270.TYPE_FOODCONSUMED (ID, DESCRIPTION, VALUE_CALORIE, AT_CREATE, AT_UPDATE)
values (
        1,
        'Banana',
        89,
        to_timestamp(
            '30-MAY-22 10.37.30.631000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '30-MAY-22 10.37.30.631000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.TYPE_FOODCONSUMED (ID, DESCRIPTION, VALUE_CALORIE, AT_CREATE, AT_UPDATE)
values (
        2,
        'Arroz',
        130,
        to_timestamp(
            '30-MAY-22 10.37.30.631000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '30-MAY-22 10.37.30.631000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.TYPE_FOODCONSUMED (ID, DESCRIPTION, VALUE_CALORIE, AT_CREATE, AT_UPDATE)
values (
        3,
        'Carne',
        143,
        to_timestamp(
            '30-MAY-22 10.37.30.631000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '30-MAY-22 10.37.30.631000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

REM INSERTING into RM92270.TYPE_PHYACTIVITY
SET DEFINE OFF;

Insert into RM92270.TYPE_PHYACTIVITY (ID, DESCRIPTION, VALUE_CALORIE, AT_CREATE, AT_UPDATE)
values (
        1,
        'Natção',
        9.33,
        to_timestamp(
            '30-MAY-22 01.37.59.723000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '30-MAY-22 01.38.03.166000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.TYPE_PHYACTIVITY (ID, DESCRIPTION, VALUE_CALORIE, AT_CREATE, AT_UPDATE)
values (
        2,
        'Hidro Ginastica',
        16.33,
        to_timestamp(
            '30-MAY-22 01.37.59.723000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '30-MAY-22 01.37.59.723000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.TYPE_PHYACTIVITY (ID, DESCRIPTION, VALUE_CALORIE, AT_CREATE, AT_UPDATE)
values (
        3,
        'Corrida',
        11.6,
        to_timestamp(
            '30-MAY-22 01.37.59.723000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '30-MAY-22 01.37.59.723000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.TYPE_PHYACTIVITY (ID, DESCRIPTION, VALUE_CALORIE, AT_CREATE, AT_UPDATE)
values (
        4,
        'Bike',
        0.89,
        to_timestamp(
            '30-MAY-22 01.37.59.723000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '30-MAY-22 01.37.59.723000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

REM INSERTING into RM92270.USER_ADDRESS
SET DEFINE OFF;

REM INSERTING into RM92270.USER_ALERTS
SET DEFINE OFF;

REM INSERTING into RM92270.USER_BLOODPRESSURE
SET DEFINE OFF;

Insert into RM92270.USER_BLOODPRESSURE (
        ID,
        USER_ID,
        VALUE_BEATS,
        AT_CREATE,
        AT_UPDATE,
        VALUE_MIN,
        VALUE_MAX
    )
values (
        4,
        35,
        88,
        to_timestamp(
            '01-JUN-22 03.07.08.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '01-JUN-22 03.07.08.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        10,
        20
    );

Insert into RM92270.USER_BLOODPRESSURE (
        ID,
        USER_ID,
        VALUE_BEATS,
        AT_CREATE,
        AT_UPDATE,
        VALUE_MIN,
        VALUE_MAX
    )
values (
        8,
        35,
        3,
        to_timestamp(
            '01-JUN-22 03.11.36.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '01-JUN-22 03.11.36.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        3,
        3
    );

Insert into RM92270.USER_BLOODPRESSURE (
        ID,
        USER_ID,
        VALUE_BEATS,
        AT_CREATE,
        AT_UPDATE,
        VALUE_MIN,
        VALUE_MAX
    )
values (
        9,
        35,
        3,
        to_timestamp(
            '01-JUN-22 03.11.40.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '01-JUN-22 03.11.40.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        3,
        3
    );

Insert into RM92270.USER_BLOODPRESSURE (
        ID,
        USER_ID,
        VALUE_BEATS,
        AT_CREATE,
        AT_UPDATE,
        VALUE_MIN,
        VALUE_MAX
    )
values (
        3,
        35,
        87,
        to_timestamp(
            '01-JUN-22 03.00.09.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '01-JUN-22 03.00.09.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        10,
        15
    );

Insert into RM92270.USER_BLOODPRESSURE (
        ID,
        USER_ID,
        VALUE_BEATS,
        AT_CREATE,
        AT_UPDATE,
        VALUE_MIN,
        VALUE_MAX
    )
values (
        6,
        35,
        97,
        to_timestamp(
            '01-JUN-22 03.09.37.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '01-JUN-22 03.09.37.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        5,
        13
    );

Insert into RM92270.USER_BLOODPRESSURE (
        ID,
        USER_ID,
        VALUE_BEATS,
        AT_CREATE,
        AT_UPDATE,
        VALUE_MIN,
        VALUE_MAX
    )
values (
        2,
        35,
        113,
        to_timestamp(
            '01-JUN-22 02.58.15.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '01-JUN-22 02.58.15.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        10,
        13
    );

Insert into RM92270.USER_BLOODPRESSURE (
        ID,
        USER_ID,
        VALUE_BEATS,
        AT_CREATE,
        AT_UPDATE,
        VALUE_MIN,
        VALUE_MAX
    )
values (
        5,
        35,
        110,
        to_timestamp(
            '01-JUN-22 03.08.18.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '01-JUN-22 03.08.18.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        12,
        15
    );

Insert into RM92270.USER_BLOODPRESSURE (
        ID,
        USER_ID,
        VALUE_BEATS,
        AT_CREATE,
        AT_UPDATE,
        VALUE_MIN,
        VALUE_MAX
    )
values (
        10,
        35,
        21,
        to_timestamp(
            '01-JUN-22 03.12.08.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '01-JUN-22 03.12.08.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        21,
        21
    );

REM INSERTING into RM92270.USER_FOODCONSUMED
SET DEFINE OFF;

Insert into RM92270.USER_FOODCONSUMED (
        ID,
        TYPE_FOODCONSUMEDID,
        USER_ID,
        QTDE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        3,
        3,
        35,
        3,
        429,
        to_timestamp(
            '31-MAY-22 02.09.11.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '31-MAY-22 02.09.11.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

REM INSERTING into RM92270.USER_HEARTBEATS
SET DEFINE OFF;

REM INSERTING into RM92270.USER_PHYSICALACTIVITY
SET DEFINE OFF;

Insert into RM92270.USER_PHYSICALACTIVITY (
        ID,
        USER_ID,
        TYPE_PHYACTIVITYID,
        TIME_ACTIVITYMINUTE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        23,
        35,
        1,
        55,
        513.15,
        to_timestamp(
            '31-MAY-22 02.11.23.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '31-MAY-22 02.11.23.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.USER_PHYSICALACTIVITY (
        ID,
        USER_ID,
        TYPE_PHYACTIVITYID,
        TIME_ACTIVITYMINUTE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        24,
        35,
        1,
        55,
        513.15,
        to_timestamp(
            '31-MAY-22 02.13.36.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '31-MAY-22 02.13.36.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.USER_PHYSICALACTIVITY (
        ID,
        USER_ID,
        TYPE_PHYACTIVITYID,
        TIME_ACTIVITYMINUTE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        20,
        35,
        1,
        20,
        186.6,
        to_timestamp(
            '31-MAY-22 02.08.36.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '31-MAY-22 02.08.36.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.USER_PHYSICALACTIVITY (
        ID,
        USER_ID,
        TYPE_PHYACTIVITYID,
        TIME_ACTIVITYMINUTE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        21,
        35,
        1,
        25,
        233.25,
        to_timestamp(
            '31-MAY-22 02.09.37.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '31-MAY-22 02.09.37.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.USER_PHYSICALACTIVITY (
        ID,
        USER_ID,
        TYPE_PHYACTIVITYID,
        TIME_ACTIVITYMINUTE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        27,
        35,
        2,
        50,
        816.5,
        to_timestamp(
            '31-MAY-22 02.16.50.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '31-MAY-22 02.16.50.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.USER_PHYSICALACTIVITY (
        ID,
        USER_ID,
        TYPE_PHYACTIVITYID,
        TIME_ACTIVITYMINUTE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        28,
        35,
        2,
        50,
        816.5,
        to_timestamp(
            '31-MAY-22 02.17.00.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '31-MAY-22 02.17.00.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.USER_PHYSICALACTIVITY (
        ID,
        USER_ID,
        TYPE_PHYACTIVITYID,
        TIME_ACTIVITYMINUTE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        31,
        35,
        3,
        1111,
        12887.6,
        to_timestamp(
            '01-JUN-22 03.12.50.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '01-JUN-22 03.12.50.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.USER_PHYSICALACTIVITY (
        ID,
        USER_ID,
        TYPE_PHYACTIVITYID,
        TIME_ACTIVITYMINUTE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        32,
        35,
        1,
        33333,
        310996.89,
        to_timestamp(
            '01-JUN-22 03.14.12.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '01-JUN-22 03.14.12.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.USER_PHYSICALACTIVITY (
        ID,
        USER_ID,
        TYPE_PHYACTIVITYID,
        TIME_ACTIVITYMINUTE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        25,
        35,
        1,
        55,
        513.15,
        to_timestamp(
            '31-MAY-22 02.14.47.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '31-MAY-22 02.14.47.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.USER_PHYSICALACTIVITY (
        ID,
        USER_ID,
        TYPE_PHYACTIVITYID,
        TIME_ACTIVITYMINUTE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        29,
        35,
        4,
        100,
        89,
        to_timestamp(
            '31-MAY-22 02.18.54.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '31-MAY-22 02.18.54.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.USER_PHYSICALACTIVITY (
        ID,
        USER_ID,
        TYPE_PHYACTIVITYID,
        TIME_ACTIVITYMINUTE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        30,
        35,
        1,
        200,
        1866,
        to_timestamp(
            '31-MAY-22 02.20.39.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '31-MAY-22 02.20.39.000000000 AM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

Insert into RM92270.USER_PHYSICALACTIVITY (
        ID,
        USER_ID,
        TYPE_PHYACTIVITYID,
        TIME_ACTIVITYMINUTE,
        VALUE_CALORIE,
        AT_CREATE,
        AT_UPDATE
    )
values (
        33,
        35,
        3,
        33333,
        386662.8,
        to_timestamp(
            '01-JUN-22 10.38.06.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        ),
        to_timestamp(
            '01-JUN-22 10.38.06.000000000 PM',
            'DD-MON-RR HH.MI.SSXFF AM'
        )
    );

REM INSERTING into RM92270.USER_PROFILE
SET DEFINE OFF;

REM INSERTING into RM92270.USERS
SET DEFINE OFF;

Insert into RM92270.USERS (
        ID,
        MAIL,
        NAME,
        PHONE_MOBILE,
        BIRTH_DATE,
        VERIFY_MAIL,
        AT_CREATE,
        AT_UPDATE,
        AT_LOGEED,
        ACTIVE,
        PASSWORD
    )
values (
        35,
        'elio.designer@hotmail.com',
        'Elio Goncalves de Lima',
        '11952550331',
        null,
        null,
        to_timestamp_tz(
            '31-MAY-22 02.03.24.000000000 AM AMERICA/SAO_PAULO',
            'DD-MON-RR HH.MI.SSXFF AM TZR'
        ),
        to_timestamp_tz(
            '31-MAY-22 02.03.24.000000000 AM AMERICA/SAO_PAULO',
            'DD-MON-RR HH.MI.SSXFF AM TZR'
        ),
        null,
        1,
        'QWJAMTAyMDMw'
    );

--------------------------------------------------------
--  DDL for Index LANGUAGES_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "RM92270"."LANGUAGES_PK" ON "RM92270"."LANGUAGES" ("ID") 

--------------------------------------------------------
--  DDL for Index TYPE_FOOD_CONSUMED_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "RM92270"."TYPE_FOOD_CONSUMED_PK" ON "RM92270"."TYPE_FOODCONSUMED" ("ID") 

--------------------------------------------------------
--  DDL for Index TYPE_PHYACTIVITY_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "RM92270"."TYPE_PHYACTIVITY_PK" ON "RM92270"."TYPE_PHYACTIVITY" ("ID") 

--------------------------------------------------------
--  DDL for Index USER_ADDRESS_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "RM92270"."USER_ADDRESS_PK" ON "RM92270"."USER_ADDRESS" ("ID") 

--------------------------------------------------------
--  DDL for Index USER_BLOOD_PRESSURE_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "RM92270"."USER_BLOOD_PRESSURE_PK" ON "RM92270"."USER_BLOODPRESSURE" ("ID") 

--------------------------------------------------------
--  DDL for Index USER_FOOD_CONSUMED_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "RM92270"."USER_FOOD_CONSUMED_PK" ON "RM92270"."USER_FOODCONSUMED" ("ID") 

--------------------------------------------------------
--  DDL for Index USER_HEARTBEATS_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "RM92270"."USER_HEARTBEATS_PK" ON "RM92270"."USER_HEARTBEATS" ("ID") 

--------------------------------------------------------
--  DDL for Index USER_PHYSICAL_ACTIVITY_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "RM92270"."USER_PHYSICAL_ACTIVITY_PK" ON "RM92270"."USER_PHYSICALACTIVITY" ("ID") 

--------------------------------------------------------
--  DDL for Index USER_PROFILE_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "RM92270"."USER_PROFILE_PK" ON "RM92270"."USER_PROFILE" ("USER_ID") 

--------------------------------------------------------
--  DDL for Index USER_PK
--------------------------------------------------------

CREATE UNIQUE INDEX "RM92270"."USER_PK" ON "RM92270"."USERS" ("ID") 

--------------------------------------------------------
--  DDL for Trigger LANGUAGES_ID_TRG
--------------------------------------------------------

CREATE OR REPLACE EDITIONABLE TRIGGER "RM92270"."LANGUAGES_ID_TRG" BEFORE
INSERT ON languages FOR EACH ROW
    WHEN (NEW.id IS NULL) BEGIN :new.id := languages_id_seq.nextval;
end;

ALTER TRIGGER "RM92270"."LANGUAGES_ID_TRG" ENABLE 

--------------------------------------------------------
--  DDL for Trigger TYPE_FOODCONSUMED_ID_TRG
--------------------------------------------------------

CREATE OR REPLACE EDITIONABLE TRIGGER "RM92270"."TYPE_FOODCONSUMED_ID_TRG" BEFORE
INSERT ON type_foodconsumed FOR EACH ROW
    WHEN (NEW.id IS NULL) BEGIN :new.id := type_foodconsumed_id_seq.nextval;
end;

ALTER TRIGGER "RM92270"."TYPE_FOODCONSUMED_ID_TRG" ENABLE 

--------------------------------------------------------
--  DDL for Trigger TYPE_PHYACTIVITY_ID_TRG
--------------------------------------------------------

CREATE OR REPLACE EDITIONABLE TRIGGER "RM92270"."TYPE_PHYACTIVITY_ID_TRG" BEFORE
INSERT ON type_phyactivity FOR EACH ROW
    WHEN (NEW.id IS NULL) BEGIN :new.id := type_phyactivity_id_seq.nextval;
end;

ALTER TRIGGER "RM92270"."TYPE_PHYACTIVITY_ID_TRG" ENABLE 

--------------------------------------------------------
--  DDL for Trigger USER_ADDRESS_ID_TRG
--------------------------------------------------------

CREATE OR REPLACE EDITIONABLE TRIGGER "RM92270"."USER_ADDRESS_ID_TRG" BEFORE
INSERT ON user_address FOR EACH ROW
    WHEN (NEW.id IS NULL) BEGIN :new.id := user_address_id_seq.nextval;
end;

ALTER TRIGGER "RM92270"."USER_ADDRESS_ID_TRG" ENABLE 

--------------------------------------------------------
--  DDL for Trigger USER_ALERTS_ID_TRG
--------------------------------------------------------

CREATE OR REPLACE EDITIONABLE TRIGGER "RM92270"."USER_ALERTS_ID_TRG" BEFORE
INSERT ON user_alerts FOR EACH ROW
    WHEN (NEW.id IS NULL) BEGIN :new.id := user_alerts_id_seq.nextval;
end;

ALTER TRIGGER "RM92270"."USER_ALERTS_ID_TRG" ENABLE 

--------------------------------------------------------
--  DDL for Trigger USER_BLOODPRESSURE_ID_TRG
--------------------------------------------------------

CREATE OR REPLACE EDITIONABLE TRIGGER "RM92270"."USER_BLOODPRESSURE_ID_TRG" BEFORE
INSERT ON user_bloodpressure FOR EACH ROW
    WHEN (NEW.id IS NULL) BEGIN :new.id := user_bloodpressure_id_seq.nextval;
end;

ALTER TRIGGER "RM92270"."USER_BLOODPRESSURE_ID_TRG" ENABLE 

--------------------------------------------------------
--  DDL for Trigger USER_FOODCONSUMED_ID_TRG
--------------------------------------------------------

CREATE OR REPLACE EDITIONABLE TRIGGER "RM92270"."USER_FOODCONSUMED_ID_TRG" BEFORE
INSERT ON user_foodconsumed FOR EACH ROW
    WHEN (NEW.id IS NULL) BEGIN :new.id := user_foodconsumed_id_seq.nextval;
end;

ALTER TRIGGER "RM92270"."USER_FOODCONSUMED_ID_TRG" ENABLE 

--------------------------------------------------------
--  DDL for Trigger USER_HEARTBEATS_ID_TRG
--------------------------------------------------------

CREATE OR REPLACE EDITIONABLE TRIGGER "RM92270"."USER_HEARTBEATS_ID_TRG" BEFORE
INSERT ON user_heartbeats FOR EACH ROW
    WHEN (NEW.id IS NULL) BEGIN :new.id := user_heartbeats_id_seq.nextval;
end;

ALTER TRIGGER "RM92270"."USER_HEARTBEATS_ID_TRG" ENABLE 

--------------------------------------------------------
--  DDL for Trigger USER_PHYSICALACTIVITY_ID_TRG
--------------------------------------------------------

CREATE OR REPLACE EDITIONABLE TRIGGER "RM92270"."USER_PHYSICALACTIVITY_ID_TRG" BEFORE
INSERT ON user_physicalactivity FOR EACH ROW
    WHEN (NEW.id IS NULL) BEGIN :new.id := user_physicalactivity_id_seq.nextval;
end;

ALTER TRIGGER "RM92270"."USER_PHYSICALACTIVITY_ID_TRG" ENABLE 

--------------------------------------------------------
--  DDL for Trigger USER_PROFILE_ID_TRG
--------------------------------------------------------

CREATE OR REPLACE EDITIONABLE TRIGGER "RM92270"."USER_PROFILE_ID_TRG" BEFORE
INSERT ON user_profile FOR EACH ROW
    WHEN (NEW.id IS NULL) BEGIN :new.id := user_profile_id_seq.nextval;
end;

ALTER TRIGGER "RM92270"."USER_PROFILE_ID_TRG" ENABLE 

--------------------------------------------------------
--  DDL for Trigger USER_ID_TRG
--------------------------------------------------------

CREATE OR REPLACE EDITIONABLE TRIGGER "RM92270"."USER_ID_TRG" BEFORE

INSERT ON "USERS" FOR EACH ROW
    WHEN (NEW.id IS NULL) BEGIN :new.id := user_id_seq.nextval;
end;

ALTER TRIGGER "RM92270"."USER_ID_TRG" ENABLE 

--------------------------------------------------------
--  Constraints for Table LANGUAGES
--------------------------------------------------------

ALTER TABLE "RM92270"."LANGUAGES"
ADD CONSTRAINT "LANGUAGES_PK" PRIMARY KEY ("ID") USING INDEX ENABLE

ALTER TABLE "RM92270"."LANGUAGES"
MODIFY (
        "DESCRIPTION" CONSTRAINT "NNC_LANGUAGES_DESCRIPTION" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."LANGUAGES"
MODIFY (
        "ID" CONSTRAINT "NNC_LANGUAGES_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."LANGUAGES"
MODIFY ("AT_UPDATE" NOT NULL ENABLE) 

--------------------------------------------------------
--  Constraints for Table TYPE_FOODCONSUMED
--------------------------------------------------------

ALTER TABLE "RM92270"."TYPE_FOODCONSUMED"
MODIFY (
        "DESCRIPTION" CONSTRAINT "NNC_TYPE_FOOD_CONSUMED_DESCRIPTION" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."TYPE_FOODCONSUMED"
MODIFY (
        "ID" CONSTRAINT "NNC_TYPE_FOOD_CONSUMED_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."TYPE_FOODCONSUMED"
MODIFY ("AT_CREATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."TYPE_FOODCONSUMED"
MODIFY ("AT_UPDATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."TYPE_FOODCONSUMED"
ADD CONSTRAINT "TYPE_FOOD_CONSUMED_PK" PRIMARY KEY ("ID") USING INDEX ENABLE 

--------------------------------------------------------
--  Constraints for Table TYPE_PHYACTIVITY
--------------------------------------------------------

ALTER TABLE "RM92270"."TYPE_PHYACTIVITY"
MODIFY (
        "DESCRIPTION" CONSTRAINT "NNC_TYPE_PHYACTIVITY_DESCRIPTION" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."TYPE_PHYACTIVITY"
MODIFY (
        "ID" CONSTRAINT "NNC_TYPE_PHYACTIVITY_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."TYPE_PHYACTIVITY"
MODIFY ("AT_CREATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."TYPE_PHYACTIVITY"
MODIFY ("AT_UPDATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."TYPE_PHYACTIVITY"
ADD CONSTRAINT "TYPE_PHYACTIVITY_PK" PRIMARY KEY ("ID") USING INDEX ENABLE 

--------------------------------------------------------
--  Constraints for Table USER_ADDRESS
--------------------------------------------------------

ALTER TABLE "RM92270"."USER_ADDRESS"
MODIFY (
        "ADDRESS" CONSTRAINT "NNC_USER_ADDRESS_ADDRESS" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_ADDRESS"
MODIFY (
        "CITY" CONSTRAINT "NNC_USER_ADDRESS_CITY" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_ADDRESS"
MODIFY (
        "DISTRICT" CONSTRAINT "NNC_USER_ADDRESS_DISTRICT" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_ADDRESS"
MODIFY (
        "ID" CONSTRAINT "NNC_USER_ADDRESS_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_ADDRESS"
MODIFY (
        "ADDRESS_NR" CONSTRAINT "NNC_USER_ADDRESS_NUMBER" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_ADDRESS"
MODIFY (
        "STATE" CONSTRAINT "NNC_USER_ADDRESS_STATE" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_ADDRESS"
MODIFY (
        "UNIT" CONSTRAINT "NNC_USER_ADDRESS_UNIT" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_ADDRESS"
MODIFY (
        "USER_ID" CONSTRAINT "NNC_USER_ADDRESS_USER_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_ADDRESS"
MODIFY ("ZIP_CODE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_ADDRESS"
MODIFY ("AT_CREATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_ADDRESS"
MODIFY ("AT_UPDATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_ADDRESS"
ADD CONSTRAINT "USER_ADDRESS_PK" PRIMARY KEY ("ID") USING INDEX ENABLE 

--------------------------------------------------------
--  Constraints for Table USER_ALERTS
--------------------------------------------------------

ALTER TABLE "RM92270"."USER_ALERTS"
MODIFY (
        "HEARTBEATS_MAX" CONSTRAINT "NNC_USER_ALERTS_HEARTBEATS_MAX" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_ALERTS"
MODIFY (
        "HEARTBEATS_MIN" CONSTRAINT "NNC_USER_ALERTS_HEARTBEATS_MIN" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_ALERTS"
MODIFY (
        "ID" CONSTRAINT "NNC_USER_ALERTS_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_ALERTS"
MODIFY (
        "USER_ID" CONSTRAINT "NNC_USER_ALERTS_USER_ID" NOT NULL ENABLE
    ) 
    
--------------------------------------------------------
--  Constraints for Table USER_BLOODPRESSURE
--------------------------------------------------------

ALTER TABLE "RM92270"."USER_BLOODPRESSURE"
MODIFY (
        "ID" CONSTRAINT "NNC_USER_BLOOD_PRESSURE_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_BLOODPRESSURE"
MODIFY ("AT_CREATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_BLOODPRESSURE"
MODIFY ("AT_UPDATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_BLOODPRESSURE"
ADD CONSTRAINT "USER_BLOOD_PRESSURE_PK" PRIMARY KEY ("ID") USING INDEX ENABLE 

--------------------------------------------------------
--  Constraints for Table USER_FOODCONSUMED
--------------------------------------------------------

ALTER TABLE "RM92270"."USER_FOODCONSUMED"
MODIFY (
        "ID" CONSTRAINT "NNC_USER_FOOD_CONSUMED_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_FOODCONSUMED"
MODIFY (
        "TYPE_FOODCONSUMEDID" CONSTRAINT "NNC_USER_FOOD_CONSUMED_TYPE_FOOD_CONSUMED_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_FOODCONSUMED"
MODIFY (
        "USER_ID" CONSTRAINT "NNC_USER_FOOD_CONSUMED_USER_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_FOODCONSUMED"
MODIFY ("AT_CREATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_FOODCONSUMED"
MODIFY ("AT_UPDATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_FOODCONSUMED"
ADD CONSTRAINT "USER_FOOD_CONSUMED_PK" PRIMARY KEY ("ID") USING INDEX ENABLE 

--------------------------------------------------------
--  Constraints for Table USER_HEARTBEATS
--------------------------------------------------------

ALTER TABLE "RM92270"."USER_HEARTBEATS"
MODIFY (
        "ID" CONSTRAINT "NNC_USER_HEARTBEATS_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_HEARTBEATS"
MODIFY (
        "USER_ID" CONSTRAINT "NNC_USER_HEARTBEATS_USER_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_HEARTBEATS"
MODIFY ("AT_CREATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_HEARTBEATS"
MODIFY ("AT_UPDATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_HEARTBEATS"
ADD CONSTRAINT "USER_HEARTBEATS_PK" PRIMARY KEY ("ID") USING INDEX ENABLE 

--------------------------------------------------------
--  Constraints for Table USER_PHYSICALACTIVITY
--------------------------------------------------------

ALTER TABLE "RM92270"."USER_PHYSICALACTIVITY"
MODIFY (
        "ID" CONSTRAINT "NNC_USER_PHYSICAL_ACTIVITY_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_PHYSICALACTIVITY"
MODIFY (
        "TYPE_PHYACTIVITYID" CONSTRAINT "NNC_USER_PHYSICAL_ACTIVITY_TYPE_PHYACTIVITY_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_PHYSICALACTIVITY"
MODIFY ("AT_CREATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_PHYSICALACTIVITY"
MODIFY ("AT_UPDATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_PHYSICALACTIVITY"
MODIFY ("USER_ID" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_PHYSICALACTIVITY"
ADD CONSTRAINT "USER_PHYSICAL_ACTIVITY_PK" PRIMARY KEY ("ID") USING INDEX ENABLE 

--------------------------------------------------------
--  Constraints for Table USER_PROFILE
--------------------------------------------------------

ALTER TABLE "RM92270"."USER_PROFILE"
MODIFY (
        "LANGUAGES_ID" CONSTRAINT "NNC_USER_PROFILE_LANGUAGES_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_PROFILE"
MODIFY (
        "USER_ID" CONSTRAINT "NNC_USER_PROFILE_USER_ID" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USER_PROFILE"
MODIFY ("AT_CREATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_PROFILE"
MODIFY ("AT_UPDATE" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USER_PROFILE"
ADD CONSTRAINT "USER_PROFILE_PK" PRIMARY KEY ("USER_ID") USING INDEX ENABLE 

--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

ALTER TABLE "RM92270"."USERS"
MODIFY (
        "AT_CREATE" CONSTRAINT "NNC_USER_ATCREATE" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USERS"
MODIFY (
        "AT_UPDATE" CONSTRAINT "NNC_USER_ATUPDATE" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USERS"
MODIFY ("ID" CONSTRAINT "NNC_USER_ID" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USERS"
MODIFY (
        "MAIL" CONSTRAINT "NNC_USER_MAIL" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USERS"
MODIFY (
        "NAME" CONSTRAINT "NNC_USER_NAME" NOT NULL ENABLE
    )

ALTER TABLE "RM92270"."USERS"
MODIFY ("PASSWORD" NOT NULL ENABLE)

ALTER TABLE "RM92270"."USERS"
ADD CONSTRAINT "USER_PK" PRIMARY KEY ("ID") USING INDEX ENABLE 

--------------------------------------------------------
--  Ref Constraints for Table USER_BLOODPRESSURE
--------------------------------------------------------

ALTER TABLE "RM92270"."USER_BLOODPRESSURE"
ADD CONSTRAINT "USER_BLOOD_PRESSURE_USER_FK" FOREIGN KEY ("USER_ID") REFERENCES "RM92270"."USERS" ("ID") ENABLE 

--------------------------------------------------------
--  Ref Constraints for Table USER_FOODCONSUMED
--------------------------------------------------------

ALTER TABLE "RM92270"."USER_FOODCONSUMED"
ADD CONSTRAINT "CONSUMED_FK1" FOREIGN KEY ("ID") REFERENCES "RM92270"."TYPE_FOODCONSUMED" ("ID") ENABLE

ALTER TABLE "RM92270"."USER_FOODCONSUMED"
ADD CONSTRAINT "USER_FOOD_CONSUMED_USER_FK" FOREIGN KEY ("USER_ID") REFERENCES "RM92270"."USERS" ("ID") ENABLE 

--------------------------------------------------------
--  Ref Constraints for Table USER_PHYSICALACTIVITY
--------------------------------------------------------

ALTER TABLE "RM92270"."USER_PHYSICALACTIVITY"
ADD CONSTRAINT "USER_PHYSICAL_ACTIVITY_TYPE_PHYACTIVITY_FK" FOREIGN KEY ("TYPE_PHYACTIVITYID") REFERENCES "RM92270"."TYPE_PHYACTIVITY" ("ID") ENABLE

ALTER TABLE "RM92270"."USER_PHYSICALACTIVITY"
ADD CONSTRAINT "USER_PHYSICAL_ACTIVITY_USER_FK" FOREIGN KEY ("USER_ID") REFERENCES "RM92270"."USERS" ("ID") ENABLE