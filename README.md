Aplikasi Quiz Game merupakan aplikasi kuis berbasis JavaFX yang memungkinkan pengguna untuk melakukan login, memilih menu, mengerjakan kuis, dan melihat hasil akhir berupa skor.
Aplikasi ini dirancang menggunakan konsep Object Oriented Programming (OOP) dan arsitektur MVC (Model View Controller) agar kode terstruktur, mudah dipahami, dan mudah dikembangkan.

Soal kuis dibaca dari file eksternal, kemudian ditampilkan satu per satu kepada pengguna. Jawaban pengguna akan diperiksa secara otomatis dan skor akhir akan disimpan ke dalam file.

STRUKTUR APLIKASI

Aplikasi dibagi ke dalam beberapa package utama, yaitu:

app

controller

model

view

util

style

Setiap package memiliki tanggung jawab masing-masing sesuai konsep MVC.

PACKAGE app

MainApp.java
MainApp.java merupakan titik awal atau entry point dari aplikasi.
Class ini menjalankan JavaFX dengan mewarisi class Application, mengatur stage utama, dan memanggil SceneManager untuk menampilkan halaman pertama, yaitu halaman login.
Class ini bertanggung jawab untuk memulai seluruh proses aplikasi Quiz Game.

SceneManager.java
SceneManager.java berfungsi untuk mengatur perpindahan antar scene dalam aplikasi.
Class ini menyimpan referensi stage utama dan mengatur navigasi antar halaman seperti login, menu, kuis, dan hasil tanpa perlu membuat stage baru setiap kali berpindah halaman.

PACKAGE controller

LoginController.java
LoginController.java bertugas mengatur logika pada halaman login.
Class ini menerima input username dari pengguna, melakukan validasi, dan mengarahkan pengguna ke menu utama jika login berhasil.

MenuController.java
MenuController.java berfungsi untuk mengatur logika pada menu utama.
Class ini menangani aksi tombol seperti memulai kuis dan keluar dari aplikasi.

QuizController.java
QuizController.java merupakan class yang mengatur jalannya kuis.
Class ini bertugas menampilkan soal, menerima jawaban pengguna, memeriksa jawaban, menghitung skor, dan mengatur perpindahan antar soal hingga kuis selesai.

PACKAGE model

Category.java
Category.java digunakan untuk merepresentasikan kategori soal dalam kuis.
Class ini menyimpan informasi kategori seperti nama kategori dan daftar soal yang termasuk dalam kategori tersebut.
Class ini membantu pengelompokan soal agar kuis lebih terstruktur.

Question.java
Question.java merupakan class induk atau abstract class yang merepresentasikan sebuah soal kuis.
Class ini menyimpan data dasar soal seperti teks pertanyaan dan jawaban yang benar, serta menyediakan method yang akan diimplementasikan oleh class turunannya.

ChoiceQuestion.java
ChoiceQuestion.java merupakan turunan dari Question.
Class ini digunakan untuk soal pilihan ganda dan menyimpan daftar pilihan jawaban yang dapat dipilih oleh pengguna.

TextQuestion.java
TextQuestion.java merupakan turunan dari Question.
Class ini digunakan untuk soal berbentuk teks dan berisi implementasi khusus untuk memeriksa jawaban berbasis teks.

Quiz.java
Quiz.java berfungsi sebagai pengelola keseluruhan kuis.
Class ini menyimpan kumpulan soal, kategori, skor, dan indeks soal yang sedang dikerjakan, serta mengatur alur kuis dari awal sampai selesai.

PACKAGE view

LoginView.java
LoginView.java berfungsi menampilkan antarmuka halaman login.
Class ini berisi komponen tampilan seperti input username dan tombol login.

MenuView.java
MenuView.java berfungsi menampilkan halaman menu utama.
Class ini menyediakan tombol untuk memulai kuis dan keluar dari aplikasi.

QuizView.java
QuizView.java menampilkan halaman kuis.
Class ini menampilkan soal dan pilihan jawaban serta menerima input jawaban dari pengguna.

ResultView.java
ResultView.java menampilkan halaman hasil kuis.
Class ini menampilkan skor akhir dan menyediakan tombol untuk kembali ke menu atau keluar dari aplikasi.

PACKAGE util

FileLoader.java
FileLoader.java berfungsi untuk membaca file soal dari folder data.
Class ini mengubah isi file soal menjadi objek Question dan Category yang dapat digunakan oleh aplikasi.

ResultWriter.java
ResultWriter.java berfungsi untuk menyimpan hasil kuis ke dalam file.
Class ini menuliskan username dan skor akhir ke file result.txt sebagai dokumentasi hasil kuis.

PACKAGE style

style.css
style.css digunakan untuk mengatur tampilan visual aplikasi JavaFX.
File ini mengatur warna, font, ukuran tombol, dan tampilan antarmuka agar aplikasi terlihat lebih menarik dan konsisten.
