CREATE SEQUENCE WK01_WORKSHOP_SEQ START 1;
CREATE TABLE public.WK01_WORKSHOP(
                                    WK01_COD_WORKSHOP BIGINT NOT NULL DEFAULT  nextval('public.WK01_WORKSHOP_SEQ'::regclass),
                                    WK01_NOME_WORKSHOP VARCHAR(255) NOT NULL ,
                                    constraint PK_WK01_WORKSHOP primary key (WK01_COD_WORKSHOP)
);