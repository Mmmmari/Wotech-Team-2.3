Calculate total Sales by City
```SQL
SELECT Owners.City, SUM(Procedures.Price) AS TotalSales
FROM Sales 
JOIN Procedures ON Sales.ProcedureCode = Procedures.ProcedureCode 
JOIN Owners ON Pets.OwnerID = Owners.OwnerID
JOIN Pets ON Pets.PetID = Sales.PetID
GROUP BY Owners.City
ORDER BY TotalSales DESC;
```
Calculate total Sales by Pet Kind
```SQL
SELECT 
    p.Kind AS PetKind,
    COALESCE(SUM(pr.Price), 0) AS TotalSales
FROM 
    Pets p
LEFT JOIN 
    Sales s ON p.PetID = s.PetID
LEFT JOIN 
    Procedures pr ON s.ProcedureCode = pr.ProcedureCode
GROUP BY 
    p.Kind
```   
Calculate total Sales by City and Pet Kind 
```SQL
SELECT Owners.City, Pets.Kind, SUM(Procedures.Price) AS TotalSales
FROM Sales 
JOIN Procedures ON Sales.ProcedureCode = Procedures.ProcedureCode 
JOIN Owners ON Pets.OwnerID = Owners.OwnerID
JOIN Pets ON Pets.PetID = Sales.PetID
GROUP BY Owners.City, Pets.Kind
ORDER BY Owners.City, Pets.Kind DESC;
```
Calculate Average sales by City
```SQL
SELECT Owners.City, AVG(Procedures.Price) AS AverageSales
FROM Sales 
JOIN Procedures ON Sales.ProcedureCode = Procedures.ProcedureCode 
JOIN Owners ON Pets.OwnerID = Owners.OwnerID
JOIN Pets ON Pets.PetID = Sales.PetID
GROUP BY Owners.City
ORDER BY AverageSales DESC;
```
