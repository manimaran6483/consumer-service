CREATE TABLE Business_Master (
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
Business_Category  VARCHAR(40) NOT NULL,
Business_Type  VARCHAR(40) NOT NULL,
Total_Employees BIGINT NOT NULL,
Business_age BIGINT NOT NULL
);


CREATE TABLE Property_Master(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
Insurance_Type varchar(30) NOT NULL,
Property_Type varchar(30) NOT NULL,
Building_Type varchar(7) NOT NULL,
Building_Age BIGINT NOT NULL
);


INSERT INTO Business_Master (Business_Category,Business_Type , Total_Employees , Business_age) VALUES  ('Retailer','Pharmacy', 90 , 2);
INSERT INTO Business_Master (Business_Category,Business_Type , Total_Employees , Business_age) VALUES  ('Retailer','Grocery', 70 , 2);
INSERT INTO Business_Master (Business_Category,Business_Type , Total_Employees , Business_age) VALUES  ('Investor','Corporate Investor', 62 , 1);
INSERT INTO Business_Master (Business_Category,Business_Type , Total_Employees , Business_age) VALUES  ('Investor',' Fund', 64 , 3);
INSERT INTO Business_Master (Business_Category,Business_Type , Total_Employees , Business_age) VALUES  ('Manufacturer','Pharma', 34 , 2);
INSERT INTO Business_Master (Business_Category,Business_Type , Total_Employees , Business_age) VALUES  ('Manufacturer','Beverage', 86 , 4);
INSERT INTO Business_Master (Business_Category,Business_Type , Total_Employees , Business_age) VALUES  ('Food Service','Coffee House', 54 , 2);
INSERT INTO Business_Master (Business_Category,Business_Type , Total_Employees , Business_age) VALUES  ('Food Service',' Chef', 47 , 3);

INSERT INTO Property_Master (Insurance_Type,Property_Type,Building_Type,Building_Age) VALUES ('Pay Back','Building','Owner', 2);
INSERT INTO Property_Master (Insurance_Type,Property_Type,Building_Type,Building_Age) VALUES ('Fire','Building','Owner', 2);
INSERT INTO Property_Master (Insurance_Type,Property_Type,Building_Type,Building_Age) VALUES ('Fire','Factory Equipment','Owner', 3);
INSERT INTO Property_Master (Insurance_Type,Property_Type,Building_Type,Building_Age) VALUES ('Burglary','Factory Equipment','Owner', 1);