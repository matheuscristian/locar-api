fetch("http://localhost:8080/usuario", {
    method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify({
        cadastroUsuario: {
            id_cadastroUsuario: 0,
            nome: "Flávio Guimarães Vilela",
            cpf: "00000000000",
            telefone: "31900000000",
            email: "test@email.com",
            dataDeNascimento: "2007-12-09",
            comprovanteCNH_id_comprovanteCNH: 1
        },
        comprovanteCNH: {
            id_comprovanteCNH: 0,
            numeroIdentificacao: "000",
            dataValidade: "2026-12-21",
            statusCNH: "valido",
            ufEmissao: "MG",
            categoria: "AH"
        }
    })
}).then((res) => {
    return res.json();
}).then((json) => {
    console.log(json);
}).catch((err) => {
    console.error(err);
});
