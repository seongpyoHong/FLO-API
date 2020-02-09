**
ㆍReferential integrity constraint violation**





**오류 :**

ERROR : HHH000315: Exception executing batch [org.h2.jdbc.JdbcBatchUpdateException: Referential integrity constraint violation: "FKOU1XVFC0SWVOFR46KFD8KHY1N: PUBLIC.AUTHCOMPOSITE FOREIGN KEY(USER_SEQ) REFERENCES PUBLIC.USER(USER_SEQ) (12)"; SQL statement:



**이유 :**

두 Entity간에 부모, 자식 관계가 맺어졌지만 각각 클래스의 ID값에 @GeneratedValue를 설정했기 때문에 각각의 시퀀스 값이 들어가게 된다. 여기서 FK제약조건이 걸려 오류가 난 것이다.



**해결책 :**

두 Entity 중에 FK를 가지는 Entity의 @GeneratedValue를 삭제한다.

