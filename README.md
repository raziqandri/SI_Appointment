# SI Appointment

Rest API asisten dosen untuk Tugas Proyek [APAP Gasal 2018/2019](https://github.com/Apap-2018)

Base url : 

API List:
* [getAllPasienIGD](#getallpasienigd)
* [getAllPasienRawatJalan](#getallpasienrawatjalan)
* [getPasien](#getpasien)
* [getAllDokter](#getalldokter)
* [getDokter](#getdokter)
* [getAllStaffFarmasi](#getallstafffarmasi)
* [getAllStaffLab](#getallstafflab)
* [addBilling](#addbilling)
* [addLabResult](#addlabresult)
* [updatePasienStatus](#updatepasienstatus)

## getAllPasienIGD

Mengembalikan daftar semua pasien yang mendaftar di IGD

**URL** : [`http://si-appointment.herokuapp.com/api/getAllPasienIGD`](http://si-appointment.herokuapp.com/api/getAllPasienIGD)

**Method** : `GET`

### Success Response

```json
{
  "status": 200,
  "message": "success",
  "result": [
    {
      "id": 2,
      "nama": "Hana Purwanti",
      "statusPasien": {
        "id": 1,
        "jenis": "Mendaftar di IGD"
      }
    },
    {
      "id": 3,
      "nama": "Kamila Utami",
      "statusPasien": {
        "id": 1,
        "jenis": "Mendaftar di IGD"
      }
    }
  ]
}
```

## getAllPasienRawatJalan

Mengembalikan daftar semua pasien yang mendaftar di Rawat Jalan

**URL** : [`http://si-appointment.herokuapp.com/api/getAllPasienRawatJalan/`](http://si-appointment.herokuapp.com/api/getAllPasienRawatJalan/)

**Method** : `GET`

### Success Response

```json
```

## getPasien

Mengembalikan info seorang pasien

**URL** : [`http://si-appointment.herokuapp.com/api/getPasien/{id}`](http://si-appointment.herokuapp.com/api/getPasien/1)

**Method** : `GET`

### Success Response

```json
{
  "status": 200,
  "message": "success",
  "result": {
    "id": 1,
    "nama": "Shania Rahmi Kusmowati",
    "statusPasien": {
      "id": 1,
      "jenis": "Mendaftar di IGD"
    }
  }
}
```

## getAllDokter

Mengembalikan daftar semua dokter

**URL** : [`http://si-appointment.herokuapp.com/api/getAllDokter`](http://si-appointment.herokuapp.com/api/getAllDokter)

**Method** : `GET`

### Success Response

```json
{
  "status": 200,
  "message": "success",
  "result": [
    {
      "id": 1,
      "nama": "Akarsana Narpati"
    },
    {
      "id": 2,
      "nama": "Agus Saptono"
    }
}
```

## getDokter

Mengembalikan info seorang dokter

**URL** : [`http://si-appointment.herokuapp.com/api/getDokter/{id}`](http://si-appointment.herokuapp.com/api/getDokter/1)

**Method** : `GET`

### Success Response

```json
{
  "status": 200,
  "message": "success",
  "result": {
    "id": 1,
    "nama": "Akarsana Narpati"
  }
}
```

## getAllStaffFarmasi

Mengembalikan daftar semua staff farmasi

**URL** : [`http://si-appointment.herokuapp.com/api/getAllStaffFarmasi`](http://si-appointment.herokuapp.com/api/getAllStaffFarmasi)

**Method** : `GET`

### Success Response

```json
{
  "status": 200,
  "message": "success",
  "result": [
    {
      "id": 1,
      "nama": "Heru Haryanto",
      "jenis": 0
    },
    {
      "id": 2,
      "nama": "Ridwan Hasim Marpaung",
      "jenis": 0
    }
  ]
}
```

## getAllStaffLab

Mengembalikan daftar semua staff Laboratorium

**URL** : [`http://si-appointment.herokuapp.com/api/getAllStaffLab`](http://si-appointment.herokuapp.com/api/getAllStaffLab)

**Method** : `GET`

### Success Response

```json
{
  "status": 200,
  "message": "success",
  "result": [
    {
      "id": 501,
      "nama": "Lanang Pangestu",
      "jenis": 1
    },
    {
      "id": 502,
      "nama": "Jayeng Kusumo",
      "jenis": 1
    }
  ]
}
```

## getStaff

Mengembalikan info seorang staff

**URL** : [`http://si-appointment.herokuapp.com/api/getStaff`](http://si-appointment.herokuapp.com/api/getStaff/1)

**Method** : `GET`

### Success Response

```json
{
  "status": 200,
  "message": "success",
  "result": {
    "id": 1,
    "nama": "Heru Haryanto",
    "jenis": 0
  }
}
```

## addBilling

Menambahkan billing ke Appointment

**URL** : `http://si-appointment.herokuapp.com/api/addBilling`

**Method** : `POST`

**Body Param** :
```json
{
  "jumlahTagihan" : 200,
  "tanggalTagihan" : "2018-10-10",
  "pasien" : {
    "id" : 1
  }
}
```

### Success Response

```json
{
  "status": 200,
  "message": "success",
  "result": {
    "jumlahTagihan" : 200,
    "tanggalTagihan" : "2018-10-10",
    "pasien" : {
      "id" : 1
    }
  }
}
```

### Failed Response

```json
{
  "status": 500,
  "message": "error data",
  "result": ""
}
```

## addLabResult

Menambahkan hasil lab ke Appointment

**URL** : `http://si-appointment.herokuapp.com/api/addLabResult`

**Method** : `POST`

**Body Param** :
```json
{
  "jenis" : "urin",
  "hasil" : "diabetes",
  "tanggalPengajuan" : "2018-10-10",
  "pasien" : {
    "id" : 1
  }
}
```

### Success Response

```json
{
  "status": 200,
  "message": "success",
  "result": {
    "jenis" : "urin",
    "hasil" : "diabetes",
    "tanggalPengajuan" : "2018-10-10",
    "pasien" : {
      "id" : 1
    }
  }
}
```

### Failed Response

```json
{
  "status": 500,
  "message": "error data",
  "result": ""
}
```

## updatePasienStatus

Mengubah status seorang pasien

**URL** : `http://si-appointment.herokuapp.com/api/updatePasien`

**Method** : `POST`

**Body Param** :
```json
{
  "id" : 1,
  "nama" : "Desmosedici",
  "statusPasien" : {
    "id" : 2
  }
}
```

### Success Response

```json
{
  "status": 200,
  "message": "success",
  "result": {
    "id" : 1,
    "nama" : "Desmosedici",
    "statusPasien" : {
      "id" : 2
    }
  }
}
```

### Failed Response

```json
{
  "status": 500,
  "message": "error data",
  "result": ""
}
```
