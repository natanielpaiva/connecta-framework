SELECT     m.id_memorando				  AS cod     ,
           m.id_memorando_can                       AS cod2    ,
           date_format(m.dt_timestamp,'%d/%m/%y') AS Data    ,
           m.assunto                              AS Assunto ,
           p.nome                                 AS Projeto ,
           tm.desc_tipo_memorando                 AS Tipo ,
           m.cod_tmp                              AS "Cod TMP",
           CASE
                          WHEN id_memorando_can IS NULL
                          THEN '---'
                          ELSE 'Visualizar memorando Retificado'
           END AS R ,
           CASE
                          WHEN
                                         (SELECT COUNT(*)
                                                         FROM    tb_passagem
                                                         WHERE   id_memorando = m.id_memorando
                                                         AND     ativo  IS NULL
                                         )
                                         = 0
                          THEN 'Transporte'
                          ELSE 'Transporte V'
           END AS 'Transporte',
           CASE
                          WHEN
                                         (SELECT COUNT(*)
                                                         FROM    tb_hospedagem
                                                         WHERE   id_memorando = m.id_memorando
                                                         AND     ativo  IS NULL
                                         )
                                         = 0
                          THEN 'Hotel'
                          ELSE 'Hotel'
           END AS 'Hotel',
           CASE
                          WHEN
                                         (SELECT COUNT(*)
                                                         FROM    tb_locacao
                                                         WHERE   id_memorando = m.id_memorando
                                                         AND     ativo  IS NULL
                                         )
                                         = 0
                          THEN 'Locação'
                          ELSE 'Locação V'
           END AS 'Locação',
           CASE
                          WHEN
                                         (SELECT COUNT(*)
                                                         FROM    tb_atividade
                                                         WHERE   id_memorando = m.id_memorando
                                                         AND     ativo  IS NULL
                                         )
                                         = 0
                          THEN 'Atividade'
                          ELSE 'Atividade V'
           END AS 'Atividade',


           CASE
                          WHEN
                                         (SELECT COUNT(*)
                                                         FROM    tb_atividade
                                                         WHERE   id_memorando = m.id_memorando
                                                         AND     ativo  IS NULL
                                         )
                                         = 0
                          THEN 'Taxi'
                          ELSE 'Taxi V'
           END AS 'Taxi',


           CASE
                          WHEN
                                         (SELECT COUNT(*)
                                                         FROM    tb_observacao
                                                         WHERE   id_memorando = m.id_memorando
                                                         AND     ativo  IS NULL
                                         )
                                         = 0
                          THEN 'Observações'
                          ELSE 'Observações A'
           END AS 'Observações',
            CASE
                          WHEN m.motivo_n_aprovado is null
                          THEN ''
                          ELSE concat('motivo reprovação')
           END AS 'Reprovação'
FROM   tb_memorando m
           INNER JOIN tb_projeto p
           ON     m.id_projeto = p.id_projeto
           LEFT JOIN tb_tipo_memorando tm
           ON     m.id_tipo_memorando = tm.id_tipo_memorando
WHERE  m.ativo       IS NULL
AND    m.status      IS NULL
ORDER BY
        Projeto	,
        Data