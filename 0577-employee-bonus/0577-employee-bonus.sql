# Write your MySQL query statement below
select EMP.name, bb.bonus from Employee as EMP left join Bonus as bb on EMP.empId = bb.empId where bb.bonus < 1000 or bb.bonus is null;