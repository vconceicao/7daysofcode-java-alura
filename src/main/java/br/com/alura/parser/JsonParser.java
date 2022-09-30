package br.com.alura.parser;

import br.com.alura.models.Content;
import br.com.alura.models.Content;

import java.util.List;

public interface JsonParser {
    List<? extends Content> parse();
}
