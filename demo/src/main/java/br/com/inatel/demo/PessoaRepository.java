package br.com.inatel.demo;

 import br.com.inatel.demo.Pessoa;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import org.springframework.stereotype.Repository;
 @Repository
 public class PessoaRepository {
 private final static HashMap<Integer, Pessoa> pessoas = new HashMap<>();
 public List<Pessoa> GetAll() {
 return new ArrayList<Pessoa>(pessoas.values());
 }
 public Pessoa Get(final int id) {
 return pessoas.get(id);
 }
 public Pessoa Add(final Pessoa pessoa) {
 if (pessoa.getId() == 0)
 pessoa.setId(generateId(pessoas.size() + 1));
 pessoas.put(pessoa.getId(), pessoa);
 return pessoa;
 }
 public void Edit(final Pessoa pessoa) {
 pessoas.remove(pessoa.getId());
 pessoas.put(pessoa.getId(), pessoa);
 }
 public void Delete(final int id) {
 pessoas.remove(id);
 }
 private int generateId(final int possible) {
 if (pessoas.containsKey(possible))
 return generateId(possible + 1);
 return possible;
 }
 }