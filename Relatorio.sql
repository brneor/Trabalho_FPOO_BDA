use breno;
/*Relatório*/

/*Numero Pacientes Atendidos e Testes Utilizado*/
select count(p.cpf) Numero_Pacientes_Atendidos
from Paciente as p 
inner join Relatorio as r on p.cpf = r.idPaciente
inner join Exame as ex on ex.id = r.idExame;


/*Criar sentença de testes utilizados*/
select count(t.id) as Testes_Utilizados
from Relatorio as r 
inner join Exame as ex on ex.id = r.idExame
inner join Teste as t on t.id = ex.idTeste;


/*Detectado*/
select count(res.descricao) Exames_Detectados
from Relatorio as re 
inner join Exame as ex on re.idExame =  ex.id
inner join ResultadoExame as res on  res.id = ex.idResultadoExame
where res.descricao like '%Detectado%';

/*Nao Detectado*/
 select count(res.descricao) Exames_Nao_Detectados
from Relatorio as re inner join Exame as ex on re.idExame =  ex.id
inner join ResultadoExame as res on  res.id = ex.idResultadoExame
where res.descricao like '%Não detectado%';

/*Pacientes para recoleta*/
select count(p.cpf) Paciente_Para_Recoleta
from Paciente as p inner join Relatorio as re on p.cpf = re.idPaciente
inner join Exame as ex on re.idExame =  ex.id
inner join ResultadoExame as res on  res.id = ex.idResultadoExame
where res.descricao like '%Recoleta%';

/*Pacientes com exame inconclusivos*/
select count(p.cpf) Paciente_Inconclusivo
from Paciente as p inner join Relatorio as re on p.cpf = re.idPaciente
inner join Exame as ex on re.idExame =  ex.id
inner join ResultadoExame as res on  res.id = ex.idResultadoExame
where res.descricao like '%Inconclusivo%';

/*Exames inválidos*/
 select count(res.descricao) Inválido
from Relatorio as re inner join Exame as ex on re.idExame =  ex.id
inner join ResultadoExame as res on  res.id = ex.idResultadoExame
where res.descricao like '%Inválido%';