select * from (
select rownum rnum, num, title, writer, writeday, readcnt, repIndent from (
select * from board order by repRoot desc, repStep asc)) 
where rnum >=11 and rnum <=20 


select * from (select rownum rnum, num, title, writer, writeday, readcnt, repIndent from (select * from board where title like '%거북%' order by repRoot desc, repStep asc)) where rnum>=1 and rnum<=10

select * from (select rownum rnum, num, title, writer, writeday, readcnt, repIndent from (select * from board where title like ? order by repRoot desc, repStep asc)) where rnum>=? and rnum<=?