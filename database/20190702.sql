SELECT A.BOOK_ID, A.BOOK_NM, A.MON_KEY, B.IN_AMT, C.ORD_AMT
  FROM ( SELECT A.BOOK_ID, A.BOOK_NM, B.MON_KEY
           FROM BOOK A CROSS JOIN ( SELECT LPAD(ROWNUM, 02, '0') MON_KEY
                                      FROM DUAL
                                    CONNECT BY ROWNUM <= 12 ) B ) A
       LEFT OUTER JOIN ( SELECT B.BOOK_ID, TO_CHAR(A.IN_DT, 'MM') MON_KEY, SUM(B.QTY) IN_AMT
                           FROM WAREHOUSE A INNER JOIN WAREHOUSE_DET B ON A.IN_NO = B.IN_NO
                          WHERE A.IN_DT > TO_TIMESTAMP('20181231 23595959', 'YYYYMMDD HH24MISSFF')
                         GROUP BY B.BOOK_ID, TO_CHAR(A.IN_DT, 'MM') ) B ON A.BOOK_ID = B.BOOK_ID AND A.MON_KEY = B.MON_KEY
       LEFT OUTER JOIN ( SELECT B.BOOK_ID, TO_CHAR(A.ORD_DT, 'MM') MON_KEY, SUM(B.UNIT_PRICE*B.QTY) ORD_AMT
                           FROM ORDERS A INNER JOIN ORDERS_DET B ON A.ORD_ID = B.ORD_ID
                          WHERE A.ORD_DT > TO_TIMESTAMP('20181231 23595959', 'YYYYMMDD HH24MISSFF')
                         GROUP BY B.BOOK_ID, TO_CHAR(A.ORD_DT, 'MM') ) C ON A.BOOK_ID = C.BOOK_ID AND A.MON_KEY = C.MON_KEY                  
ORDER BY A.BOOK_ID, A.MON_KEY;

SELECT B.BOOK_ID, TO_CHAR(A.ORD_DT, 'MM') MON_KEY, SUM(B.UNIT_PRICE*B.QTY) ORD_AMT
  FROM ORDERS A INNER JOIN ORDERS_DET B ON A.ORD_ID = B.ORD_ID
 WHERE A.ORD_DT > TO_TIMESTAMP('20181231 23595959', 'YYYYMMDD HH24MISSFF')
GROUP BY B.BOOK_ID, TO_CHAR(A.ORD_DT, 'MM');

-- ��������
SELECT LPAD(' ', 2*(LEVEL), ' ')||A.EMP_NM, A.EMP_NO, A.EMP_NM
  FROM EMP A
START WITH A.EMP_MANAGER_NO IS NULL
CONNECT BY A.EMP_MANAGER_NO = PRIOR A.EMP_NO;

SELECT LPAD(' ', 2*(LEVEL), ' ')||A.EMP_NM, A.EMP_NO, A.EMP_NM
  FROM EMP A
START WITH 1=1
CONNECT BY A.EMP_MANAGER_NO = PRIOR A.EMP_NO;

SELECT LPAD(' ', 2*(LEVEL), ' ')||A.EMP_NM, A.EMP_NO, A.EMP_NM
  FROM EMP A
START WITH 1=1
CONNECT BY PRIOR A.EMP_MANAGER_NO = A.EMP_NO;
-- test
