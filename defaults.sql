insert into Material
values 
	(1, "Aspirado traqueal"),
    (2, "Escarro"),
    (3, "Lavado broncoalveolar"),
    (4, "Aspirado brônquico"),
    (5, "Aspirado naso-faríngeo"),
    (6, "Swab combinado de orofaringe e nasofaringe"),
    (7, "Secreção traqueal"),
    (8, "Swab de nasofaringe");

insert into ResultadoExame
values
	(1, "Inconclusivo"),
    (2, "Inválido"),
    (3, "Detectado"),
    (4, "Recoleta"),
    (5, "Não detectado");
    
insert into tipoProfissional
values 
	(1, "Enfermerio"),
    (2, "Farmacêutico"),
    (3, "Médico");

insert into tipoUsuario
values 
	(1, "Cadastro"),
    (2, "Responsável técnico"),
    (3, "Supervisor"),
    (4, "Paciente");
    
INSERT INTO Usuario 
VALUES 
	('breno', 1, null, 'fwq321', 'Breno Reis Peres'),
    ('cadastro', 1, null, '321321', 'Cadastrildo da Silva'),
    ('rt', 2, null, '321321', 'Responsildo Santos'),
    ('supervisor', 3, null, '321321', 'Supervisiolando Carvalho'),
    ('paciente', 4, null, '321321', 'Pacivaldo Esperança');