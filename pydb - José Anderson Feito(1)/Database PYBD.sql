PGDMP         !                {            pydb    15.3    15.3 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16403    pydb    DATABASE     �   CREATE DATABASE pydb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United Kingdom.1252';
    DROP DATABASE pydb;
                postgres    false            �            1259    16404    pessoa_id_seq    SEQUENCE     v   CREATE SEQUENCE public.pessoa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.pessoa_id_seq;
       public          postgres    false            �            1259    16405    pessoa    TABLE     �   CREATE TABLE public.pessoa (
    id integer DEFAULT nextval('public.pessoa_id_seq'::regclass) NOT NULL,
    nome character varying(40)
);
    DROP TABLE public.pessoa;
       public         heap    postgres    false    214            �          0    16405    pessoa 
   TABLE DATA           *   COPY public.pessoa (id, nome) FROM stdin;
    public          postgres    false    215   0       �           0    0    pessoa_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.pessoa_id_seq', 15, true);
          public          postgres    false    214            g           2606    16410    pessoa pessoa_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT pessoa_pkey;
       public            postgres    false    215            �   x   x�ȱ1F���L�0pJ*$�ۀ�p���$�PѳA��{�g-��8�)X�LF�(��rT�a���q��E����
�-^�,-)��ݤo0��\�xI�i�S�G�$�?q%�     