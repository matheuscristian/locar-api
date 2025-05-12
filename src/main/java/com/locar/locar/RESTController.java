package com.locar.locar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.locar.locar.model.CadastroFuncionario;
import com.locar.locar.model.CadastroUsuario;
import com.locar.locar.model.CadastroVeiculo;
import com.locar.locar.model.ComprovanteCNH;
import com.locar.locar.model.Devolucao;
import com.locar.locar.model.Documentacao;
import com.locar.locar.model.LocacaoDados;
import com.locar.locar.model.ManutencaoVeiculo;
import com.locar.locar.model.Pagamento;
import com.locar.locar.model.Taxa;
import com.locar.locar.model.requests.POSTLocacao;
import com.locar.locar.model.requests.POSTUsuario;
import com.locar.locar.model.requests.POSTVeiculo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RESTController {
    @PostMapping(path = "/usuario")
    CadastroUsuario postUser(@RequestBody POSTUsuario body) {
        CadastroUsuario cadastroUsuario = body.getCadastroUsuario();
        ComprovanteCNH comprovanteCNH = body.getComprovanteCNH();

        String comprovanteSQL = "INSERT INTO comprovantecnh (numeroIdentificacao, dataValidade, statusCNH, ufEmissao, categoria) VALUES (?, ?, ?, ?, ?)";
        String usuarioSQL = "INSERT INTO cadastrousuario (nome, cpf, telefone, email, dataDeNascimento, comprovanteCNH_id_comprovanteCNH) VALUES (?, ?, ?, ?, ?, ?)";
        String selectUsuarioSQL = "SELECT * FROM cadastrousuario WHERE id_cadastroUsuario = ?;";

        return LocarApplication.DatabaseConnection((Connection conn) -> {
            try {
                PreparedStatement pStatement = conn.prepareStatement(comprovanteSQL,
                        PreparedStatement.RETURN_GENERATED_KEYS);

                pStatement.setString(1, comprovanteCNH.getNumeroIdentificacao());
                pStatement.setString(2, comprovanteCNH.getDataValidade());
                pStatement.setString(3, comprovanteCNH.getStatusCNH());
                pStatement.setString(4, comprovanteCNH.getUfEmissao());
                pStatement.setString(5, comprovanteCNH.getCategoria());

                int affectedRows = pStatement.executeUpdate();

                if (affectedRows == 0) {
                    return null;
                }

                ResultSet rs = pStatement.getGeneratedKeys();
                rs.next();
                int comprovanteCNH_id = rs.getInt(1);

                pStatement = conn.prepareStatement(usuarioSQL, PreparedStatement.RETURN_GENERATED_KEYS);

                pStatement.setString(1, cadastroUsuario.getNome());
                pStatement.setString(2, cadastroUsuario.getCpf());
                pStatement.setString(3, cadastroUsuario.getTelefone());
                pStatement.setString(4, cadastroUsuario.getEmail());
                pStatement.setString(5, cadastroUsuario.getDataDeNascimento());
                pStatement.setInt(6, comprovanteCNH_id);

                affectedRows = pStatement.executeUpdate();

                if (affectedRows == 0) {
                    return null;
                }

                rs = pStatement.getGeneratedKeys();
                rs.next();
                int novoUsuarioID = rs.getInt(1);

                pStatement = conn.prepareStatement(selectUsuarioSQL);
                pStatement.setInt(1, novoUsuarioID);

                rs = pStatement.executeQuery();

                if (rs.next()) {
                    return new CadastroUsuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6), rs.getInt(7));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        });
    }

    @PostMapping(path = "/veiculo")
    public CadastroVeiculo postVeiculo(@RequestBody POSTVeiculo body) {
        Documentacao documentacao = body.getDocumentacao();
        CadastroVeiculo cadastroVeiculo = body.getCadastroVeiculo();
        ManutencaoVeiculo manutencaoVeiculo = body.getManutencaoVeiculo();

        String INSERT_documentacaoSQL = "INSERT INTO documentacao (ipva, seguroVencimento, quilometragemAtual, dataAquisicao, vistoria) VALUES (?, ?, ?, ?, ?);";
        String INSERT_cadastroveiculoSQL = "INSERT INTO cadastroveiculo (marca, modelo, ano, cor, placa, valorTotal, statusOcupacao, renavam, tipoCambio, capacidade, documentacao_id_documentacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        String INSERT_manutencaoveiculoSQL = "INSERT INTO manutencaoveiculo (dataManutencao, tipoManutencao, custo, observacao, cadastroVeiculo_id_cadastroVeiculo) VALUES (?, ?, ?, ?, ?);";

        String SELECT_cadastroveiculoSQL = "SELECT * FROM cadastroveiculo WHERE id_cadastroVeiculo = ?;";

        return LocarApplication.DatabaseConnection((Connection conn) -> {
            try {
                PreparedStatement pStatement = conn.prepareStatement(INSERT_documentacaoSQL,
                        PreparedStatement.RETURN_GENERATED_KEYS);

                pStatement.setString(1, documentacao.getIpva());
                pStatement.setString(2, documentacao.getSeguroVencimento());
                pStatement.setDouble(3, documentacao.getQuilometragemAtual());
                pStatement.setString(4, documentacao.getDataAquisicao());
                pStatement.setString(5, documentacao.getVistoria());

                int affectedRows = pStatement.executeUpdate();

                if (affectedRows == 0) {
                    return null;
                }

                ResultSet rs = pStatement.getGeneratedKeys();
                rs.next();
                int novoID = rs.getInt(1);

                pStatement = conn.prepareStatement(INSERT_cadastroveiculoSQL, PreparedStatement.RETURN_GENERATED_KEYS);

                pStatement.setString(1, cadastroVeiculo.getMarca());
                pStatement.setString(2, cadastroVeiculo.getModelo());
                pStatement.setString(3, cadastroVeiculo.getAno());
                pStatement.setString(4, cadastroVeiculo.getCor());
                pStatement.setString(5, cadastroVeiculo.getPlaca());
                pStatement.setDouble(6, cadastroVeiculo.getValorTotal());
                pStatement.setShort(7, cadastroVeiculo.getStatusOcupacao());
                pStatement.setString(8, cadastroVeiculo.getRenavam());
                pStatement.setString(9, cadastroVeiculo.getTipoCambio());
                pStatement.setInt(10, cadastroVeiculo.getCapacidade());
                pStatement.setInt(11, novoID);

                affectedRows = pStatement.executeUpdate();

                if (affectedRows == 0) {
                    return null;
                }

                rs = pStatement.getGeneratedKeys();
                rs.next();
                novoID = rs.getInt(1);

                pStatement = conn.prepareStatement(INSERT_manutencaoveiculoSQL);

                pStatement.setString(1, manutencaoVeiculo.getDataManutencao());
                pStatement.setString(2, manutencaoVeiculo.getTipoManutencao());
                pStatement.setDouble(3, manutencaoVeiculo.getCusto());
                pStatement.setString(4, manutencaoVeiculo.getObservacao());
                pStatement.setInt(5, novoID);

                affectedRows = pStatement.executeUpdate();

                if (affectedRows == 0) {
                    return null;
                }

                pStatement = conn.prepareStatement(SELECT_cadastroveiculoSQL);
                pStatement.setInt(1, novoID);

                rs = pStatement.executeQuery();

                if (rs.next()) {
                    return new CadastroVeiculo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getShort(8), rs.getString(9),
                            rs.getString(10), rs.getInt(11), rs.getInt(12));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        });
    }

    @PostMapping(path = "/locacao")
    public LocacaoDados postLocacao(@RequestBody POSTLocacao body) {
        LocacaoDados locacaoDados = body.getLocacaoDados();
        Devolucao devolucao = body.getDevolucao();
        Pagamento pagamento = body.getPagamento();

        String INSERT_locacaoDados = "INSERT INTO locacaodados (valorTotal, status, dataSaida, dataDevolucao, cadastroUsuario_id_cadastroUsuario, cadastroFuncionario_id_cadastroFuncionario, cadastroVeiculo_id_cadastroVeiculo) VALUES (?, ?, ?, ?, ?, ?, ?);";
        String INSERT_devolucao = "INSERT INTO devolucao (dataDevolucao, combustivelRestante, statusVeiculo, observacao) VALUES (?, ?, ?, ?);";
        String INSERT_pagamento = "INSERT INTO pagamento (valorTotal, data, metodoPagamento, devolucao_id_devolucao, taxa_id_taxa, locacaoDados_id_locacaoDados) VALUES (?, ?, ?, ?, ?, ?);";

        String SELECT_locacao = "SELECT * FROM locacaodados WHERE id_locacaoDados = ?;";

        return LocarApplication.DatabaseConnection((Connection conn) -> {
            try {
                PreparedStatement pStatement = conn.prepareStatement(INSERT_locacaoDados,
                        PreparedStatement.RETURN_GENERATED_KEYS);

                pStatement.setDouble(1, locacaoDados.getValorTotal());
                pStatement.setString(2, locacaoDados.getStatus());
                pStatement.setString(3, locacaoDados.getDataSaida());
                pStatement.setString(4, locacaoDados.getDataDevolucao());
                pStatement.setInt(5, locacaoDados.getCadastroUsuario_id_cadastroUsuario());
                pStatement.setInt(6, locacaoDados.getCadastroFuncionario_id_cadastroFuncionario());
                pStatement.setInt(7, locacaoDados.getCadastroVeiculo_id_cadastroVeiculo());

                int affectedRows = pStatement.executeUpdate();

                if (affectedRows == 0) {
                    return null;
                }

                ResultSet rs = pStatement.getGeneratedKeys();
                rs.next();
                int locacaoID = rs.getInt(1);

                pStatement = conn.prepareStatement(INSERT_devolucao, PreparedStatement.RETURN_GENERATED_KEYS);

                pStatement.setString(1, devolucao.getDataDevolucao());
                pStatement.setDouble(2, devolucao.getCombustivelRestante());
                pStatement.setString(3, devolucao.getStatusVeiculo());
                pStatement.setString(4, devolucao.getObservacao());

                affectedRows = pStatement.executeUpdate();

                if (affectedRows == 0) {
                    return null;
                }

                rs = pStatement.getGeneratedKeys();
                rs.next();
                int devolucaoID = rs.getInt(1);

                pStatement = conn.prepareStatement(INSERT_pagamento);

                pStatement.setDouble(1, pagamento.getValorTotal());
                pStatement.setString(2, pagamento.getData());
                pStatement.setString(3, pagamento.getMetodoPagamento());
                pStatement.setInt(4, devolucaoID);
                pStatement.setInt(5, pagamento.getTaxa_id_taxa());
                pStatement.setInt(6, locacaoID);

                pStatement.executeUpdate();

                if (affectedRows == 0) {
                    return null;
                }

                pStatement = conn.prepareStatement(SELECT_locacao);
                pStatement.setInt(1, locacaoID);

                rs = pStatement.executeQuery();

                if (rs.next()) {
                    return new LocacaoDados(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        });
    }

    @PostMapping(path = "/funcionario")
    public CadastroFuncionario postFuncionario(@RequestBody CadastroFuncionario cadastroFuncionario) {
        String INSERT_funcionario = "INSERT INTO cadastrofuncionario (nome, cpf, email, telefone, cargo, senha) VALUES (? ,? ,? ,?, ?, ?);";
        String SELECT_funcionario = "SELECT * FROM cadastrofuncionario WHERE id_cadastroFuncionario = ?;";

        return LocarApplication.DatabaseConnection((Connection conn) -> {
            try {
                PreparedStatement pStatement = conn.prepareStatement(INSERT_funcionario,
                        PreparedStatement.RETURN_GENERATED_KEYS);

                pStatement.setString(1, cadastroFuncionario.getNome());
                pStatement.setString(2, cadastroFuncionario.getCpf());
                pStatement.setString(3, cadastroFuncionario.getEmail());
                pStatement.setString(4, cadastroFuncionario.getTelefone());
                pStatement.setString(5, cadastroFuncionario.getCargo());
                pStatement.setString(6, cadastroFuncionario.getSenha());

                int affectedRows = pStatement.executeUpdate();

                if (affectedRows == 0) {
                    return null;
                }

                ResultSet rs = pStatement.getGeneratedKeys();
                rs.next();
                int funcionarioID = rs.getInt(1);

                pStatement = conn.prepareStatement(SELECT_funcionario);
                pStatement.setInt(1, funcionarioID);

                rs = pStatement.executeQuery();

                if (rs.next()) {
                    return new CadastroFuncionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6), rs.getString(7));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        });
    }

    @GetMapping(path = "/funcionario")
    public CadastroFuncionario getFuncionario(@RequestParam String email, @RequestParam String senha) {
        String SELECT_funcionario = "SELECT * FROM cadastrofuncionario WHERE email = ? AND senha = ?;";

        return LocarApplication.DatabaseConnection((Connection conn) -> {
            try {
                PreparedStatement pStatement = conn.prepareStatement(SELECT_funcionario);
                pStatement.setString(1, email);
                pStatement.setString(2, senha);

                ResultSet rs = pStatement.executeQuery();

                if (rs.next()) {
                    return new CadastroFuncionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6), rs.getString(7));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        });
    }

    @GetMapping(path = "/taxas")
    public Taxa[] getTaxas() {
        String SELECT_taxa = "SELECT * FROM taxa;";

        return LocarApplication.DatabaseConnection((Connection conn) -> {
            try {
                PreparedStatement pStatement = conn.prepareStatement(SELECT_taxa);

                ResultSet rs = pStatement.executeQuery();

                ArrayList<Taxa> taxas = new ArrayList<>();

                while (rs.next()) {
                    taxas.add(new Taxa(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
                }

                return taxas.toArray(new Taxa[taxas.size()]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        });
    }

    @GetMapping(path = "/usuarios")
    public CadastroUsuario[] getUsuarios() {
        String SELECT_taxa = "SELECT * FROM cadastrousuario;";

        return LocarApplication.DatabaseConnection((Connection conn) -> {
            try {
                PreparedStatement pStatement = conn.prepareStatement(SELECT_taxa);

                ResultSet rs = pStatement.executeQuery();

                ArrayList<CadastroUsuario> usuarios = new ArrayList<>();

                while (rs.next()) {
                    usuarios.add(new CadastroUsuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6), rs.getInt(7)));
                }

                return usuarios.toArray(new CadastroUsuario[usuarios.size()]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        });
    }

    @GetMapping(path = "/veiculos")
    public CadastroVeiculo[] getVeiculos() {
        String SELECT_taxa = "SELECT * FROM cadastroveiculo;";

        return LocarApplication.DatabaseConnection((Connection conn) -> {
            try {
                PreparedStatement pStatement = conn.prepareStatement(SELECT_taxa);

                ResultSet rs = pStatement.executeQuery();

                ArrayList<CadastroVeiculo> veiculos = new ArrayList<>();

                while (rs.next()) {
                    veiculos.add(new CadastroVeiculo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getShort(8), rs.getString(9),
                            rs.getString(10), rs.getInt(11), rs.getInt(12)));
                }

                return veiculos.toArray(new CadastroVeiculo[veiculos.size()]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        });
    }
}
