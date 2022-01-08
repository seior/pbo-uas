# TUGAS UAS

## Cara Pakai
- Download project
- Buat database dan table baru di mysql atau mariadb
    ```mysql
    create database penjualan_laptop;
    
    use penjualan_laptop;
    
    create table user
    (
        username varchar(255) primary key,
        password varchar(255)                    not null,
        nama     varchar(255)                    not null,
        alamat   varchar(255)                    not null,
        no_telp  varchar(13)                     not null,
        jk       enum ('laki-laki', 'perempuan') not null
    );
    
    create table laptop
    (
        id        integer auto_increment primary key,
        harga     varchar(255)           not null,
        nama      varchar(255)           not null,
        terjual   integer default (0),
        kondisi   enum ('baru', 'bekas') not null,
        tipe      varchar(255),
        deskripsi text                   not null
    );
    
    create table transaksi
    (
        id              integer auto_increment primary key,
        id_laptop       integer                                                  not null,
        jasa_pengiriman varchar(255)                                             not null,
        alamat          varchar(255)                                             not null,
        pembayaran      enum ('Mandiri Virtual Account', 'OVO', 'GOPAY', 'DANA') not null,
        total_bayar     varchar(255)                                             not null,
        constraint fk_transaksi_laptop foreign key (id_laptop) references laptop (id)
    );
    
    create table status_pemesanan
    (
        id                integer auto_increment primary key,
        id_transaksi      integer not null,
        status_pembayaran varchar(255),
        status_pemesanan  varchar(255),
        constraint fk_status_transaksi foreign key (id_transaksi) references transaksi (id)
    );
    
    create table toko
    (
        username  varchar(255) primary key,
        password  varchar(255) not null,
        nama_toko varchar(255) not null,
        alamat    varchar(255) not null,
        rating    float        not null default (0)
    );
    
    alter table transaksi
        add username varchar(255) not null;
    alter table transaksi
        add constraint fk_transaksi_user foreign key (username) references user (username);
    
    alter table laptop
        add username varchar(255) not null;
    alter table laptop
        add constraint fk_laptop_user foreign key (username) references toko (username);
    
    alter table user
        add role enum ('user', 'admin') not null default ('user');
  
    insert into user (username, password, nama, alamat, no_telp, jk)
        values ('admin', '123', 'Mancing Mania !!!, mantapp', 'Bogor', '0851551332156', 'laki-laki');
    ```
- Jalakan file Main.java di folder src

## Login Admin
- pilih login sebagai pembeli lalu isi :
  ```text 
  username : admin
  password : 123
  ```
