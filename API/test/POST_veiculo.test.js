fetch("http://localhost:8080/veiculo", {
    method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify({
        documentacao: {
            id_documentacao: 0,
            ipva: "2037-2-3",
            seguroVencimento: "2037-2-3",
            quilometragemAtual: 1000,
            dataAquisicao: "2077-12-2",
            vistoria: "2077-2-12"
        },
        cadastroVeiculo: {
            id_cadastroVeiculo: 0,
            marca: "Toyota",
            modelo: "Corolla",
            ano: 2024,
            cor: "Prata",
            placa: "blah",
            valorTotal: 2400,
            statusOcupacao: 1,
            renavam: "ah",
            tipoCambio: "Manual",
            capacidade: 5,
            documentacao_id_documentacao: 0
        },
        manutencaoVeiculo: {
            id_manutencaoVeiculo: 0,
            dataManutencao: "2024-12-9",
            tipoManutencao: "2024-12-9",
            custo: 2400,
            cadastroVeiculo_id_cadastroVeiculo: 0
        }
    })
}).then((res) => {
    return res.text();
}).then((text) => {
    console.log(text);
}).catch((err) => {
    console.error(err);
});
