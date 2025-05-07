fetch("http://localhost:8080/locacao", {
    method: "POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({
        locacaoDados: {
            id_locacaoDados: 0,
            valorTotal: 0,
            status: "sla",
            dataSaida: "2022-2-2",
            dataDevolucao: "2022-2-2",
            cadastroUsuario_id_cadastroUsuario: 1,
            cadastroFuncionario_id_cadastroFuncionario: 1,
            cadastroVeiculo_id_cadastroVeiculo: 1
        },
        devolucao: {
            id_devolucao: 0,
            dataDevolucao: "2022-2-2",
            combustivelRestante: 0,
            statusVeiculo: "sla",
            observacao: "ahhhhhh"
        },
        pagamento: {
            id_pagamento: 0,
            valorTotal: 0,
            data: "2022-2-2",
            metodoPagamento: "Crédito",
            devolucao_id_devolucao: 0,
            taxa_id_taxa: 1,
            locacaoDados_id_locacaoDados: 0
        }
    })
}).then((res) => {
    return res.text();
}).then((text) => {
    console.log(text);
}).catch((err) => {
    console.error(err);
});
