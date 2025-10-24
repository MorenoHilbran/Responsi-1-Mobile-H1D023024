# Responsi 1 - Pemrograman Mobile


## Identitas

| Informasi | Detail |
|-----------|--------|
| Nama | Moreno Hilbran Glenardi |
| NIM | H1D023024 |
| Shift Baru | B |
| Shift Asal | H |

---

## Video Demo

https://github.com/user-attachments/assets/620492ef-6660-42be-af01-74b99b0e587f

---

## Alur Data

### API Setup
- Base URL: `https://api.football-data.org/v4/`
- Endpoint: `GET /teams/{id}`
- Team ID: 62 (Everton FC)
- Header: `X-Auth-Token: 85288e18b2b041f394f00132d9afedeb`

### Alur Pengambilan Data

```
Alur data pada aplikasi ini berjalan langsung dari Activity ke API menggunakan Coroutines.

API Request
    ↓
Retrofit (ApiClient.apiService.getTeam(62))
    ↓
Gson (Parse JSON)
    ↓
Data Model (TeamResponse, Player, Coach)
    ↓
Activity (HeadCoachActivity / TeamSquadActivity)
    ↓
Update UI (Adapter / TextViews)
```

### MainActivity
- Menampilkan deskripsi statis (hardcoded) tentang Everton FC.
- Menyediakan 3 menu navigasi (CardView) untuk:
- Club History
- Head Coach
- Team Squad

### ClubHistoryActivity
- Menampilkan halaman statis (hardcoded) yang berisi sejarah klub.

### HeadCoachActivity
- Memanggil API untuk mendapatkan data tim (termasuk pelatih).
- Menampilkan data pelatih (Nama, Kebangsaan, Tanggal Lahir) dalam TextView.

### TeamSquadActivity
- Memanggil API untuk mendapatkan daftar pemain (squad).
- Menampilkan daftar pemain dalam RecyclerView menggunakan PlayerAdapter.
- Kartu pemain diwarnai berdasarkan posisi:
  - Goalkeeper: Kuning
  - Defender: Biru
  - Midfielder: Hijau
  - Forward: Merah
- Saat kartu pemain di-klik, TeamSquadActivity akan menampilkan PlayerDetail (BottomSheetFragment).
- PlayerDetail menampilkan info lengkap pemain (Nama, Posisi, Kebangsaan, Tgl. Lahir).

---

## Model Data
```
TeamResponse
├── id: Int
├── name: String
├── coach: Coach
│   ├── id: Int
│   ├── name: String
│   ├── dateOfBirth: String
│   └── nationality: String
└── squad: List<Player>
    ├── id: Int
    ├── name: String
    ├── position: String
    ├── dateOfBirth: String
    └── nationality: String
```
---

## Struktur Project
```
app/src/main/
├── java/com/example/responsi1mobileh1d023024/
│   ├── MainActivity.kt
│   ├── ClubHistoryActivity.kt
│   ├── HeadCoachActivity.kt
│   ├── TeamSquadActivity.kt
│   ├── adapter/
│   │   └── PlayerAdapter.kt
│   ├── data/
│   │   ├── api/
│   │   │   ├── ApiClient.kt
│   │   │   └── ApiService.kt
│   │   └── model/
│   │       ├── Coach.kt
│   │       ├── Player.kt
│   │       └── TeamResponse.kt
│   └── fragment/
│       └── PlayerDetail.kt
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   ├── activity_club_history.xml
│   │   ├── activity_head_coach.xml
│   │   ├── activity_team_squad.xml
│   │   ├── item_player_card.xml
│   │   └── fragment_player_detail.xml
│   ├── drawable/
│   │   ├── stadium.png
│   │   ├── everton_fc_logo.png
│   │   ├── coach.png
│   │   ├── history.png
│   │   ├── ic_bola.xml
│   │   ├── ic_coach.xml
│   │   └── ic_team.xml
│   └── values/
│       ├── strings.xml
│       └── colors.xml
└── AndroidManifest.xml
```
---

## Library yang Digunakan

- Retrofit 2.9.0 - HTTP client untuk API
- Gson 2.10.1 - Parsing JSON
- RecyclerView 1.3.2 - Menampilkan daftar (skuad)
- CardView 1.0.0 - Komponen kartu
- Material 1.12.0 - Komponen UI (BottomSheet)
- Kotlin Coroutines (LifecycleScope) - Manajemen thread untuk panggilan API

