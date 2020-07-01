/*Banco Miriã*/

use breno;

/*Recupere o resultado do exame e a quantidade total de pacientes que tiveram
aquele resultado.*/ 
SELECT 
    res.descricao AS resultado,
    COUNT(*) Quantidade_total_pacientes
FROM
    ResultadoExame AS res
        INNER JOIN
    Exame AS ex ON res.id = ex.idResultadoExame
        INNER JOIN
    Paciente AS p ON ex.idPaciente = p.cpf
GROUP BY res.descricao;


/*Recupere os dados de todos os pacientes que tiveram o resultado do exame
positivo (exame detectado).*/
SELECT 
    p.*
FROM
    ResultadoExame AS res
        INNER JOIN
    Exame AS ex ON res.id = ex.idResultadoExame
        INNER JOIN
    Paciente AS p ON ex.idPaciente = p.cpf
WHERE
    res.descricao like '%Detectado%';

/*Recupere a quantidade de pacientes que tiveram o resultado do exame
positivo (exame detectado) e apresentavam alguma comorbidade e a
quantidade de pacientes que tiveram o resultado positivo, porém não
apresentavam nenhuma comorbidade.*/

/*Detectado com comorbidade*/
SELECT 
    COUNT(p.cpf) Pacientes_Com_Comorbidade
FROM
    Paciente AS p
        INNER JOIN
    Exame AS ex ON p.cpf = ex.idPaciente
        INNER JOIN
    ResultadoExame AS res ON ex.idResultadoExame = res.id
WHERE
    res.descricao LIKE '%Detectado%'
        AND p.risco = 1;

/*Detectado sem comorbidade*/
SELECT 
    COUNT(p.cpf) Pacientes_Com_Comorbidade
FROM
    Paciente AS p
        INNER JOIN
    Exame AS ex ON p.cpf = ex.idPaciente
        INNER JOIN
    ResultadoExame AS res ON ex.idResultadoExame = res.id
WHERE
    res.descricao LIKE '%Detectado%'
        AND p.risco = 0;
        
/*Recupere a idade mínima, máxima e média dos pacientes testados positivo
(exame detectado).*/

select 
min(TIMESTAMPDIFF(YEAR, p.DataNascimento, NOW())) Idade_Minima,
max(TIMESTAMPDIFF(YEAR, p.DataNascimento, NOW())) Idade_Maxima,
avg(TIMESTAMPDIFF(YEAR, p.DataNascimento, NOW())) Idade_media

from Paciente as p 

inner join Exame as ex  on p.cpf = ex.idPaciente
inner join ResultadoExame as res on res.id = ex.idResultadoExame
where res.descricao like '% Detectado%';

/*Recupere a quantidade de exames realizadas por dia por esse laboratório.*/
SELECT 
    COUNT(ex.id) AS Quantidade_Exame,
    ex.dataExame AS Data_Exames
FROM
    Exame AS ex
        INNER JOIN
  Exame as x ON ex.id = x.id
GROUP BY ex.dataExame;