# SI Appointment

Rest API asisten dosen untuk Tugas Proyek [APAP Gasal 2018/2019](https://github.com/Apap-2018)

Base url : 

API List:
* [getAllPasien](#getallpasien)
* [getAllPasienIGD](#getallpasienigd)
* [getAllPasienRawatJalan](#getallpasienrawatjalan)
* [getPasien](#getpasien)
* [getPasienByListId](#getpasienbylistid)
* [getAllDokter](#getalldokter)
* [getDokter](#getdokter)
* [getAllStaffFarmasi](#getallstafffarmasi)
* [getAllStaffLab](#getallstafflab)
* [addBilling](#addbilling)
* [addLabResult](#addlabresult)
* [updatePasienStatus](#updatepasienstatus)

## getAllPasien

Mengembalikan daftar semua pasien

**URL** : [`http://si-appointment.herokuapp.com/api/{kodeGroupBesar}/getAllPasien`](http://si-appointment.herokuapp.com/api/1/getAllPasien)

**Method** : `GET`

### Success Response

```json
{
	"status": 200,
	"message": "success",
	"result": [
		{
			"id": 85,
			"nama": "Nabila Pratiwi",
			"tanggalRujukan": null,
			"statusPasien": {
				"id": 1,
				"jenis": "Mendaftar di IGD"
			},
			"poliRujukan": null
		},
		{
			"id": 91,
			"nama": "Tami Permata",
			"tanggalRujukan": null,
			"statusPasien": {
				"id": 1,
				"jenis": "Mendaftar di IGD"
			},
			"poliRujukan": null
		}
	]
}
```

## getAllPasienIGD

Mengembalikan daftar semua pasien yang mendaftar di IGD

**URL** : [`http://si-appointment.herokuapp.com/api/{kodeGroupBesar}/getAllPasienIGD`](http://si-appointment.herokuapp.com/api/1/getAllPasienIGD)

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
			"tanggalRujukan": null,
			"statusPasien": {
				"id": 1,
				"jenis": "Mendaftar di IGD"
			},
			"poliRujukan": null
		},
		{
			"id": 3,
			"nama": "Kamila Utami",
			"tanggalRujukan": null,
			"statusPasien": {
				"id": 1,
				"jenis": "Mendaftar di IGD"
			},
			"poliRujukan": null
		}
	]
}
```

## getAllPasienRawatJalan

Mengembalikan daftar semua pasien yang mendaftar di Rawat Jalan

**URL** : [`http://si-appointment.herokuapp.com/api/{kodeGroupBesar}/getAllPasienRawatJalan/`](http://si-appointment.herokuapp.com/api/1/getAllPasienRawatJalan/)

**Method** : `GET`

### Success Response

```json
{
	"status": 200,
	"message": "success",
	"result": [
		{
			"id": 3001,
			"nama": "Lalita Namaga",
			"tanggalRujukan": "2018-08-13",
			"statusPasien": {
				"id": 7,
				"jenis": "Mendaftar di Rawat Jalan"
			},
			"poliRujukan": {
				"id": 1,
				"nama": "Poli Penyakit Dalam"
			}
		},
		{
			"id": 3007,
			"nama": "Rini Hesti Riyanti",
			"tanggalRujukan": "2018-07-22",
			"statusPasien": {
				"id": 7,
				"jenis": "Mendaftar di Rawat Jalan"
			},
			"poliRujukan": {
				"id": 2,
				"nama": "Poli Mata"
			}
		}
	]
}
```

**List Poli Rujukan** :
* 1, 'Poli Penyakit Dalam'
* 2, 'Poli Mata'
* 3, 'Poli Saraf'
* 4, 'Poli THT'
* 5, 'Poli Gigi dan Mulut'
* 6, 'Poli Konsultasi Gizi'
* 7, 'Poli Fisioterapi'
* 8, 'Poli Penyakit Dalam'

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
		"tanggalRujukan": null,
		"statusPasien": {
			"id": 1,
			"jenis": "Mendaftar di IGD"
		},
		"poliRujukan": null
	}
}
```

## getPasienByListId

Mengembalikan info pasien yang berada pada list

**URL** : [`http://si-appointment.herokuapp.com/api/getPasien?listId=5,10&resultType=List`](http://si-appointment.herokuapp.com/api/getPasien?listId=5,10&resultType=List)

**Parameter** :
* listId = long[]
* resultType = "Map" / "List"

**Method** : `GET`

### Success Response as Map

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "5": {
            "id": 5,
            "nama": "Usyi Palastri",
            "tanggalRujukan": null,
            "statusPasien": {
                "id": 1,
                "jenis": "Mendaftar di IGD"
            },
            "poliRujukan": null
        },
        "10": {
            "id": 10,
            "nama": "Ina Nuraini",
            "tanggalRujukan": null,
            "statusPasien": {
                "id": 1,
                "jenis": "Mendaftar di IGD"
            },
            "poliRujukan": null
        }
    }
}
```

### Success Response as List

```json
{
	"status": 200,
	"message": "success",
	"result": [
		{
			"id": 5,
			"nama": "Usyi Palastri",
			"tanggalRujukan": null,
			"statusPasien": {
				"id": 1,
				"jenis": "Mendaftar di IGD"
			},
			"poliRujukan": null
		},
		{
			"id": 10,
			"nama": "Ina Nuraini",
			"tanggalRujukan": null,
			"statusPasien": {
				"id": 1,
				"jenis": "Mendaftar di IGD"
			},
			"poliRujukan": null
		}
	]
}
```

## getAllDokter

Mengembalikan daftar semua dokter

**URL** : [`http://si-appointment.herokuapp.com/api/{kodeGroupBesar}/getAllDokter`](http://si-appointment.herokuapp.com/api/1/getAllDokter)

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
	]
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

## getDokterByListId

Mengembalikan info dokter yang berada pada list

**URL** : [`http://si-appointment.herokuapp.com/api/getDokter?listId=1,75&resultType=List`](http://si-appointment.herokuapp.com/api/getDokter?listId=1,75&resultType=List)

**Parameter** :
* listId = long[]
* resultType = "Map" / "List"

**Method** : `GET`

### Success Response as Map

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "1": {
            "id": 1,
            "nama": "Akarsana Narpati"
        },
        "75": {
            "id": 75,
            "nama": "Garang Prabowo"
        }
    }
}
```

### Success Response as List

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
            "id": 75,
            "nama": "Garang Prabowo"
        }
    ]
}
```

## getAllStaffFarmasi

Mengembalikan daftar semua staff farmasi

**URL** : [`http://si-appointment.herokuapp.com/api/{kodeGroupBesar}/getAllStaffFarmasi`](http://si-appointment.herokuapp.com/api/1/getAllStaffFarmasi)

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

**URL** : [`http://si-appointment.herokuapp.com/api/{kodeGroupBesar}/getAllStaffLab`](http://si-appointment.herokuapp.com/api/1/getAllStaffLab)

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

**URL** : [`http://si-appointment.herokuapp.com/api/getStaff/{id}`](http://si-appointment.herokuapp.com/api/getStaff/1)

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

## getStafByListId

Mengembalikan info staf yang berada pada list

**URL** : [`http://si-appointment.herokuapp.com/api/getStaff?listId=2,65&resultType=List`](http://si-appointment.herokuapp.com/api/getStaff?listId=2,65&resultType=List)

**Parameter** :
* listId = long[]
* resultType = "Map" / "List"

**Method** : `GET`

### Success Response as Map

```json
{
    "status": 200,
    "message": "success",
    "result": {
        "2": {
            "id": 2,
            "nama": "Ridwan Hasim Marpaung",
            "jenis": 0
        },
        "65": {
            "id": 65,
            "nama": "Joko Marbun",
            "jenis": 0
        }
    }
}
```

### Success Response as List

```json
{
    "status": 200,
    "message": "success",
    "result": [
        {
            "id": 2,
            "nama": "Ridwan Hasim Marpaung",
            "jenis": 0
        },
        {
            "id": 65,
            "nama": "Joko Marbun",
            "jenis": 0
        }
    ]
}
```

## addBilling

Menambahkan billing ke Appointment

**URL** : `http://si-appointment.herokuapp.com/api/{kodeGroupBesar}/addBilling`

**Method** : `POST`

**Header**: `Content-Type: application/json`

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
		"id": 1,
		"jumlahTagihan": 200,
		"tanggalTagihan": "2018-10-10",
		"pasien": {
			"id": 1
		}
	}
}
```

### Failed Response

```json
{
	"status": 500,
	"message": "error data",
	"result": null
}
```

## addLabResult

Menambahkan hasil lab ke Appointment

**URL** : `http://si-appointment.herokuapp.com/api/{kodeGroupBesar}/addLabResult`

**Method** : `POST`

**Header**: `Content-Type: application/json`

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
		"id": 1,
		"jenis": "urin",
		"hasil": "diabetes",
		"tanggalPengajuan": "2018-10-10",
		"pasien": {
			"id": 1
		}
	}
}
```

### Failed Response

```json
{
	"status": 500,
	"message": "error data",
	"result": null
}
```

## updatePasienStatus

Mengubah status seorang pasien.

**URL** : `http://si-appointment.herokuapp.com/api/{kodeGroupBesar}/updatePasien`

**Method** : `POST`

**Header**: `Content-Type: application/json`

**Body Param** :
```json
{
	"id": 1,
	"nama": "Desmosedici",
	"tanggalRujukan" : "2018-02-14",
	"poliRujukan" : {
		"id" : 1
	},
	"statusPasien": {
		"id": 5
	}
}
```
Key "tanggalRujukan" dan "poliRujukan" pada Body Param bersifat opsional.

**List Status** :
* 1, 'Mendaftar di IGD'
* 2, 'Berada di IGD'
* 3, 'Selesai di IGD'
* 4, 'Mendaftar di Rawat Inap'
* 5, 'Berada di Rawat Inap'
* 6, 'Selesai di Rawat Inap'
* 7, 'Mendaftar di Rawat Jalan'
* 8, 'Berada di Rawat Jalan'
* 9, 'Selesai di Rawat Jalan'

### Success Response

```json
{
	"status": 200,
	"message": "success",
	"result": {
		"id": 1,
		"nama": "Desmosedici",
		"tanggalRujukan": "2018-02-14",
		"statusPasien": {
			"id": 5
		},
		"poliRujukan": {
			"id": 1
		}
	}
}
```

### Failed Response

```json
{
	"status": 500,
	"message": "error data",
	"result": null
}
```
