package br.com.inatel.demo;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.inatel.demo.Pessoa;
import br.com.inatel.demo.PessoaRepository;

 @RestController
 public class PessoaController {
    @Autowired
    private PessoaRepository _pessoaRepository;

    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public List<Pessoa> Get() {
        return _pessoaRepository.GetAll();
    }

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "id") int id) {
        Pessoa pessoa = _pessoaRepository.Get(id);
        if (pessoa != null)
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public Pessoa Post(/*@Valid*/ @RequestBody Pessoa pessoa) {
        return _pessoaRepository.Add(pessoa);
    }

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") int id, /*@Valid*/
        @RequestBody Pessoa newPessoa) {
            Pessoa oldPessoa = _pessoaRepository.Get(id);
            if (oldPessoa != null) {
                Pessoa pessoa = oldPessoa;
                pessoa.setNome(newPessoa.getNome());
                _pessoaRepository.Edit(pessoa);
                return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id) {
        Pessoa pessoa = _pessoaRepository.Get(id);
        if (pessoa != null) {
            _pessoaRepository.Delete(pessoa.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
 }