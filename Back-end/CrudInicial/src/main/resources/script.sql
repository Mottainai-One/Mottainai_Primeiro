drop table if exists UserAccount cascade;
drop table if exists Employee cascade;
drop table if exists Store cascade;
drop table if exists SubscriptionPlan cascade;
drop table if exists Company cascade;
drop table if exists Administration cascade;
 
create table Company(
	CNPJ varchar(14),
	Name varchar(120) not null,
	Complement varchar(250),
	Email varchar(60) not null,
	RegistrationDate date not null default current_date,
	State varchar(80) not null,
	Street varchar(120) not null,
	City varchar(100) not null,
	Neighborhood varchar(60) not null,
	ZipCode varchar(8) not null,
	Number varchar(60) not null,
	Description varchar(250),
 
	constraint chkCompanyName 
	check (trim(name, Neighborhood) <> ''),
	constraint pkCompany primary key (CNPJ),
	constraint unCompanyEmail 
	unique (Email),
	constraint chkCompanyEmail 
    check(Email ~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}'),
	constraint chkCompanyCNPJ 
	check(length(CNPJ) = 14 and CNPJ ~ '^[0-9]+$'),
	constraint chkCompanyZipCode 
	check(length(ZipCode) = 8 and ZipCode ~ '^[0-9]+$')
);
 
create table SubscriptionPlan(
	Id serial,
	Description varchar(250) not null,
	Status varchar(20) default 'Ativo' not null,
	CreationDate date not null default current_date,
	Price decimal(10,2) not null,
	StoreLimit int not null,
	CompanyCNPJ varchar(20) not null,
	constraint pkSubscriptionPlan primary key(ID),
	constraint chkSubscriptionPlanStatus 
	check (status in ('Ativo', 'Inativo')),
 
	constraint unSubscriptionPlanCompanyCNPJ
	unique(CompanyCNPJ),
 
	constraint chkSubscriptionPlanPrice
	check(Price > 0),
	constraint fkSubscriptionPlanCompany 
	foreign key (CompanyCNPJ) references Company(CNPJ)
	on delete cascade
	on update restrict
);
 
create table Store(
	StoreCode serial,
	Email varchar(60) not null,
	Complement varchar(250),
	Department varchar(120) not null,
	Telephone varchar(15) not null,
	Status varchar(20) default 'Ativo' not null,
	Number varchar(60) not null,
	Street varchar(120) not null,
	City varchar(100) not null,
	Neighborhood varchar(60) not null,
	ZipCode varchar(8) not null,
	State varchar(80) not null,
	Description varchar(250),
	fkCompanyCNPJ varchar(20) not null,
	constraint pkStore primary key (StoreCode),
	constraint unStoreEmail 
	unique (Email),
	constraint fkStoreCompany 
	foreign key (fkCompanyCNPJ) references Company(CNPJ)
	on delete cascade
	on update restrict,
	constraint chkStoreStatus 
	check (status in ('Ativo', 'Inativo')),
	constraint chkStoreEmail 
	check (Email ~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}'),
	constraint chkStoreZipCode
	check(length(ZipCode) = 8 and ZipCode ~ '^[0-9]+$'),
 
	constraint chkStoreTelephone
	check(regexp_replace(Telephone, '[^0-9]', '', 'g') ~ '^[0-9]{10,11}')
);
 
create table Employee(
	CPF varchar(11) not null,
	Name varchar(100) not null,
	Surname varchar(100) not null,
	BirthDate date not null,
	EmploymentDate date not null,
	StoreCode int not null,
	constraint pkEmployee primary key(CPF),
 
	constraint chkEmployeeName
	check(Name ~ '^[A-Za-zÀ-ÿ ]+$'),
 
	constraint chkEmployeeSurname
	check(Surname ~ '^[A-Za-zÀ-ÿ ]+$'),
	constraint fkEmployeeStore 
	foreign key(StoreCode) references Store(StoreCode)
	on delete cascade
	on update restrict,
 
	constraint chkEmployeeBirthDate
	check (BirthDate < current_date),
 
	constraint chkEmployeeEmploymentDate
	check (EmploymentDate >= BirthDate + interval '16 years'),
	constraint chkEmployeeCPF 
	check(length(CPF) = 11 and CPF  ~ '^[0-9]+$')
);
 
create table UserAccount(
	ID serial,
	Username varchar(100) not null,
	Email varchar(100) not null,
	Password varchar(255) not null,
	RegistrationDate date not null default current_date,
	LastAccess timestamp,
	Status varchar(10) not null default 'Ativo',
	Position varchar(50) not null,
	EmployeeCPF varchar(11) not null,
	constraint pkUser primary key(id),
	constraint unUserEmail 
	unique(Email),
	constraint unUserUsername 
	unique(Username),
	constraint unUserEmployee 
	unique(EmployeeCPF),
 
	constraint chkUserPosition 
    check(Position ~ '^[A-Za-zÀ-ÿ ]+$' and Position in ('Gerente', 'Subgerente', 'RH', 'Estoquista', 'Operador de caixa', 'Empacotador', 'Repositor')),
	constraint chkUserStatus 
	check(Status in ('Ativo', 'Inativo')),
	constraint chkUserEmail 
	check(Email ~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}'),
	constraint chkUserPassword 
	check(length(Password) >= 8),
 
	constraint chkUserLastAccess
	check(LastAccess >= RegistrationDate),
	constraint fkUserEmployee 
	foreign key(EmployeeCPF) references Employee(CPF)
	on delete cascade
	on update restrict
);
 
create table Administration(
	ID serial,
	Email varchar(100) not null,
	Password varchar(255) not null,
	constraint pkAdministration primary key(ID),
	constraint unAdministrationEmail 
	unique(Email),
	constraint chkAdministrationEmail 
	check(Email ~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}')
);
 
insert into Company (CNPJ, Name, Email, RegistrationDate, ZipCode, State, City, Neighborhood, Street, Number, Complement, Description) values
('02914460038204', 'Swift', 'swiftresolve@swift.com.br', '2026-06-17', '01452905', 'São Paulo', 'São Paulo', 'Vila Jaguara', 'Avenida Marginal Direita do Rio Tietê', '500', 'Andar 03', 'Empresa de varejo alimentar swift'),
('47508411000156', 'Companhia Brasileira de Distribuição', 'ouvidoria@gpabr.com', '2026-06-18', '01402901', 'São Paulo', 'São Paulo', 'Jardim Paulista', 'Avenida Brigadeiro Luís Antônio, 3172', '3142', 'Andar 05', 'Grupo pão de açúcar gpa');
 
insert into SubscriptionPlan (Description, Status, CreationDate, Price, StoreLimit, CompanyCNPJ) values
('Start', 'Ativo', '2026-05-08', 299.90, 5, '02914460038204'),
('Growth', 'Ativo', '2026-05-11', 499.90, 15, '47508411000156');
 
insert into Store (Email, Department, Telephone, Status, Number, Street, City, Neighborhood, ZipCode, State, fkCompanyCNPJ, Description) values
('swiftresolve@swift.com.br', 'Varejo alimentar', '1140208588', 'Ativo', '541', 'Av. Dos Autonomistas', 'Osasco', 'Vila Yara', '06020000', 'São Paulo', '02914460038204', 'Filial osasco vila yara'),
('ouvidoria@gpabr.com', 'Varejo alimentar', '1146156031', 'Ativo', 'Km23', 'Rodovia Raposo Tavares, Km 23 (Área B)', 'Cotia', 'Granja Viana', '06709015', 'São Paulo', '47508411000156', 'Filial cotia granja viana');
 
insert into Employee (CPF, Name, Surname, BirthDate, EmploymentDate, StoreCode) values
('11122233344', 'Carlos', 'Eduardo', '1995-05-20', '2026-01-10', 1),
('55566677788', 'Ana', 'Oliveira', '1992-11-02', '2026-03-15', 2);
 
insert into UserAccount (Username, Email, Password, RegistrationDate, LastAccess, Status, Position, EmployeeCPF) values
('breno_admin', 'breno@plataforma.com', 'senhaSegura123', '2026-06-17', '2026-06-18 16:40:37', 'Ativo', 'Gerente', '11122233344'),
('clara_usuario', 'clara@cliente.com', 'mudar@12345', '2026-06-18', '2026-06-18 11:26:56', 'Ativo', 'Estoquista', '55566677788');
 
insert into Administration (Email, Password) values
('mottainaiestoque@institutojef.org.br', 'MottainaiLegal123');