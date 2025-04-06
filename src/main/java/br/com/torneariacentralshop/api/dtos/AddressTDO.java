package br.com.torneariacentralshop.api.dtos;

public record AddressTDO(
		int id,
        int usuarioId,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
        ) {}
