mylist<-list(name="David",age=20,city="Mumbai")
print(mylist)

empid=c(1,2,3,4)
empName=c("XYZ","ABC","PQR","MNO")
numberOfEmp=4

empList=list("ID"=empid,"Name"=empName,"TotalEmp"=numberOfEmp)
print(empList$Name)
print(empList$Name[2])
#Accessing the numberOfEmp column and will display date, i.e.4
print(empList[3][1])

empid=c(1,2,3,4)
empName=c("Nandita","Jeet","Sairaj","Aryan")
numberOfEmp=4
empList1=list("ID"=empid,"Name"=empName,"TotalEmp"=numberOfEmp)

empList1$'TotalEmp'=5

empList1[[1]][5]=5
empList1[[2]][5]="DEF"

print(empList1)

empList1[[2]][1]="SUBA"
empList1$Name