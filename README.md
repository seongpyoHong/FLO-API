### `GET` Album 검색

http://localhost:5000/search?locale=ch&title=song1_1

문자열로 앨범/곡을 검색해서 제목이 검색어를 포함하는 앨범과 곡을 찾는 API

- 해당 앨범, 노래를 이용할 수 없다면 해당 앨범, 노래가 검색 X

**PARAMS**

- locale : ch

- title : song1_1

**Example Request**

```javascript
Unirest.setTimeouts(0, 0);
HttpResponse<String> response = Unirest.get("http://localhost:5000/search?locale=ch&title=song1_1")
  .asString();
```

**Example Response**

```
200 - OK
[
  {
    "id": 1,
    "albumTitle": "album_1",
    "songList": [
      {
        "id": 1,
        "songName": "song1_1",
        "track": 1,
        "length": 10
      }
    ]
  }
]
```

---

### `GET` Album 페이지 조회

http://localhost:5000/albums?locale=ch&page=1

앨범을 10개 단위로 paging

- pages object에는 아래와 같은 link가 포함
  - first: 결과의 첫 페이지 URI
  - prev: 현재 response의 이전 페이지 URI
  - next: 현재 response의 다음 페이지 URI
  - last: 결과의 마지막 페이지 URI
  - pages object에는 필요한 link들만 포함 (예) 1page를 요청하였을 때, `first`와 `prev` link X

**PARAMS**

- locale : ch

- page : 1

**Example Request**

```javascript
Unirest.setTimeouts(0, 0);
HttpResponse<String> response = Unirest.get("http://localhost:5000/albums?locale=ch&page=1")
  .asString();
```

##### Example Response

```
200 - OK
{
  "pages": {
    "next": "http://localhost:5000/albums/?page=2",
    "last": "http://localhost:5000/albums/?page=2"
  },
  "albums": [
    {
      "id": 1,
      "albumTitle": "album_1",
      "songList": [
        {
          "id": 1,
          "songName": "song1_1",
          "track": 1,
          "length": 10
        },
        {
          "id": 2,
          "songName": "song1_2",
          "track": 2,
          "length": 11
        }
      ]
    },
    {
      "id": 2,
      "albumTitle": "album_2",
      "songList": [
        {
          "id": 3,
          "songName": "song2_1",
          "track": 1,
          "length": 12
        }
      ]
    },
    {
      "id": 3,
      "albumTitle": "album_3",
      "songList": [
        {
          "id": 4,
          "songName": "song3_1",
          "track": 1,
          "length": 13
        }
      ]
    },
    {
      "id": 5,
      "albumTitle": "album_1",
      "songList": []
    },
    {
      "id": 6,
      "albumTitle": "album_1",
      "songList": []
    },
    {
      "id": 7,
      "albumTitle": "album_1",
      "songList": []
    },
    {
      "id": 8,
      "albumTitle": "album_1",
      "songList": []
    },
    {
      "id": 9,
      "albumTitle": "album_1",
      "songList": []
    },
    {
      "id": 10,
      "albumTitle": "album_1",
      "songList": []
    },
    {
      "id": 11,
      "albumTitle": "album_1",
      "songList": []
    }
  ]
}
```

---

###  `POST`  Playlist 생성 

http://localhost:5000/playlist

- 해당 사용자의 playlist를 생성
- 한 사용자는 여러 개의 playlist를 가질 수 있다.
- playlist 이름 지정하여 저장
- Request Body : user id / playlist name
- Response : 해당 사용자의 전체 playlist 조회 URL로 redirect

**HEADERS**

- Content-Type

- application/json

**BODY**  `JSON`

```javascript
{
	"userId" : 1,
	"name"	 : "test2" 
}
```

**Example Request**

```javascript
Unirest.setTimeouts(0, 0);
HttpResponse<String> response = Unirest.post("http://localhost:5000/playlist")
  .header("Content-Type", "application/json")
  .body("{\n\t\"userId\" : 1,\n\t\"name\"\t : \"test1\" \n}")
  .asString();
```

**Example Response**

```javascript
200 － OK
redirect:/playlist/1
```

---

### `PUT`  Playlist 곡 추가

http://localhost:5000/playlist/1

- 노래를 playlist에 추가

**HEADERS**

- Content-Type

- application/json

**BODY** ` raw`

```javascript
{
	"songName" : "song1_2",
	"playlistName" : "test2"
}
```

**Example Request**

```java
Unirest.setTimeouts(0, 0);
HttpResponse<String> response = Unirest.put("http://localhost:5000/playlist/1")
  .header("Content-Type", "application/json")
  .body("{\n\t\"songName\" : \"song1_2\",\n\t\"playlistName\" : \"test2\"\n}")
  .asString();
```

**Example Response**

```
200 - OK
{
  "playlistName": "test2",
  "songList": [
    {
      "songName": "song1_1",
      "track": 1,
      "length": 10
    },
    {
      "songName": "song1_2",
      "track": 2,
      "length": 11
    }
  ]
}
```



---

### `GET` Playlist 조회

http://localhost:5000/playlist/1

- 특정 사용자의 모든 플레이리스트 조회 

**Example Request**

```javascript
Unirest.setTimeouts(0, 0);
HttpResponse<String> response = Unirest.get("http://localhost:5000/playlist/1")
  .asString();
```

**Example Response**

```javascript
200 － OK

[
  {
    "playlistName": "test1",
    "songList": [
      {
        "songName": "song1_1",
        "track": 1,
        "length": 10
      },
      {
        "songName": "song1_2",
        "track": 2,
        "length": 11
      }
    ]
  },
  {
    "playlistName": "test2",
    "songList": [
      {
        "songName": "song1_1",
        "track": 1,
        "length": 10
      },
      {
        "songName": "song1_2",
        "track": 2,
        "length": 11
      }
    ]
  }
]
```

---

### `DEL` Playlist 삭제

http://localhost:5000/playlist/1?name=test1

- 사용자의 특정 playlist 1개를 삭제

- 사용자 전체 playlist 목록으로 redirect

**PARAMS**

- name : test1

**Example Request**

```javascript
Unirest.setTimeouts(0, 0);
HttpResponse<String> response = Unirest.delete("http://localhost:5000/playlist/1?name=test1")
  .asString();
```

**Example Response**

```javascript
200 － OK
redirect:/playlist1
```

