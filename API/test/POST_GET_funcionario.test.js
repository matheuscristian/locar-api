// fetch("http://localhost:8080/funcionario", {
//     method: "POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({
//         id_cadastroFuncionario: 0,
//         nome: "Kenia Teixeira",
//         cpf: "0201314089",
//         email: "kenia-teste@email.com",
//         telefone: "31999999999",
//         cargo: "Faxineira",
//         senha: "12345678"
//     })
// }).then((res) => {
//     return res.text();
// }).then((text) => {
//     console.log(text);
// }).catch((err) => {
//     console.error(err);
// });

fetch(`http://localhost:8080/funcionario?email=kenia-teste@email.com&senha=12345678`).then((res) => {
    return res.text();
}).then((text) => {
    console.log(text);
}).catch((err) => {
    console.error(err);
});