package org.springframework.samples.utec.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.utec.model.Alumno;
import org.springframework.samples.utec.model.Grupo;
import org.springframework.samples.utec.model.Res_formulario;
import org.springframework.samples.utec.model.Resultado;
import org.springframework.samples.utec.model.Test;
import org.springframework.samples.utec.model.User;
import org.springframework.samples.utec.model.Valores;
import org.springframework.samples.utec.repository.AlumnoRepository;
import org.springframework.samples.utec.repository.FichaFormRepository;
import org.springframework.samples.utec.repository.GrupoRepository;
import org.springframework.samples.utec.repository.ResultadoRepository;
import org.springframework.samples.utec.repository.TestRepository;
import org.springframework.samples.utec.repository.UserRepository;
import org.springframework.samples.utec.repository.ValorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UtecServiceImpl implements UtecService {

    private AlumnoRepository alumnoRepository;
    private ResultadoRepository resultadoRepository;
    private GrupoRepository grupoRepository;
    private TestRepository testRepository;
    private ValorRepository valoresRepository;
    private UserRepository userRepository;
    private FichaFormRepository fichaFormRepository;
    
    @Autowired
    public UtecServiceImpl(UserRepository userRepository, AlumnoRepository alumnoRepository, ResultadoRepository resultadoRepository, ValorRepository valoresRepository, GrupoRepository grupoRepository, TestRepository testRepository, FichaFormRepository fichaFormRepository) {
        this.valoresRepository = valoresRepository;
        this.alumnoRepository = alumnoRepository;
        this.resultadoRepository = resultadoRepository;
        this.grupoRepository = grupoRepository;
        this.testRepository = testRepository;
        this.userRepository = userRepository;
        this.fichaFormRepository = fichaFormRepository;
    }

	public UtecServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public Collection<Alumno> filterResultadoByCarrera(String dato) throws DataAccessException {
		return alumnoRepository.filterDataCar(dato);
	}
	
	@Override
	public Collection<Alumno> filterResultadoByEnfermedad(String dato) throws DataAccessException {
		return alumnoRepository.filterDataEnf(dato);
	}
	
	@Override
	public Collection<Alumno> filterResultadoByDeporte(String dato) throws DataAccessException {
		return alumnoRepository.filterDataDep(dato);
	}
	
	@Override
	public Collection<Alumno> filterResultadoByApoyo(String dato) throws DataAccessException {
		return alumnoRepository.filterDataApo(dato);
	}
	
	@Override
	public Collection<Alumno> filterResultadoByCarEnf(String dato, String dato2) throws DataAccessException {
		return alumnoRepository.filterDataBy2Filtros1(dato, dato2);
	}
	
	@Override
	public Collection<Alumno> filterResultadoByCarDep(String dato, String dato2) throws DataAccessException {
		return alumnoRepository.filterDataBy2Filtros2(dato, dato2);
	}
	
	@Override
	public Collection<Alumno> filterResultadoByCarApo(String dato, String dato2) throws DataAccessException {
		return alumnoRepository.filterDataBy2Filtros3(dato, dato2);
	}
	
	@Override
	public Collection<Alumno> filterResultadoByEnfDep(String dato, String dato2) throws DataAccessException {
		return alumnoRepository.filterDataBy2Filtros4(dato, dato2);
	}
	
	@Override
	public Collection<Alumno> filterResultadoByEnfApo(String dato, String dato2) throws DataAccessException {
		return alumnoRepository.filterDataBy2Filtros5(dato, dato2);
	}
	
	@Override
	public Collection<Alumno> filterResultadoByDepApo(String dato, String dato2) throws DataAccessException {
		return alumnoRepository.filterDataBy2Filtros6(dato, dato2);
	}
	
	
	@Override
	public Collection<Alumno> filterResultadoByCED(String dato, String dato2, String dato3) throws DataAccessException {
		return alumnoRepository.filterDataBy3Filtros1(dato, dato2, dato3);
	}
	
	@Override
	public Collection<Alumno> filterResultadoByCEA(String dato, String dato2, String dato3) throws DataAccessException {
		return alumnoRepository.filterDataBy3Filtros2(dato, dato2, dato3);
	}
	
	@Override
	public Collection<Alumno> filterResultadoByCDA(String dato, String dato2, String dato3) throws DataAccessException {
		return alumnoRepository.filterDataBy3Filtros3(dato, dato2, dato3);
	}
	
	@Override
	public Collection<Alumno> filterResultadoByEDA(String dato, String dato2, String dato3) throws DataAccessException {
		return alumnoRepository.filterDataBy3Filtros4(dato, dato2, dato3);
	}
	
	
	@Override
	public Collection<Alumno> filterResultadoBy(String car, String enf, String dep, String apo) throws DataAccessException {
		return alumnoRepository.filterData(car, enf, dep, apo);
	}
	
	/* Alumnos */
    @Override
	@Transactional(readOnly = true)
	public Collection<Alumno> findAlumnoByLastName(String lastName) throws DataAccessException {
		return alumnoRepository.findByLastName(lastName);
    }
	
    @Override
    @Transactional(readOnly = true)
    public Alumno findAlumnoById(int id) throws DataAccessException {
    	return alumnoRepository.findAlumnoById(id);
    }
	 
    @Override
    @Transactional(readOnly = true)
    public Collection<Alumno> findAlumnos() throws DataAccessException {
    	return alumnoRepository.findAll();
    }
    
	@Override
	@Transactional(readOnly = true)
	public Collection<Alumno> findAlumnosGroupByLastName(String alumnoLastname, String grupo)
			throws DataAccessException {
		return alumnoRepository.findByGroup(alumnoLastname, Integer.parseInt(grupo));
	}
	
	@Override
	public ArrayList<String> findByGroupByLastNameCorreo(String name) throws DataAccessException {
		return alumnoRepository.findByGroupByNameCorreo(name);
	}
	
	@Override
	public Alumno findAlumnoByCodigo(String codigo) throws DataAccessException {
		return alumnoRepository.findAlumnoByCodigo(codigo);
	}

	@Override
	public Alumno findAlumnoByLastNameC(String lastName) throws DataAccessException {
		return alumnoRepository.findAlumnoByLastnameC(lastName);
	}
	
	@Override
	public Collection<Alumno> findAlumnosByTestEstres(String testName) throws DataAccessException {
		return alumnoRepository.findByTestEstres(testName);
	}

	@Override
	public ArrayList<Integer> findByGroupByIdCorreo(String name) throws DataAccessException {
		return alumnoRepository.findByGroupByIdesCorreo(name);
	}

	
	/* Users */
	@Override
	@Transactional(readOnly = true)
	public User findUserById(int id) throws DataAccessException {
		return  userRepository.findUserById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public User findByUsername(String username) throws DataAccessException {
		return userRepository.findUserByUsername(username);
	}

	@Override
	public Collection<User> findUserByLastName(String userLastname) throws DataAccessException {
		return userRepository.findUserByLastName(userLastname);
	}

	@Override
	public void saveUser(User user) throws DataAccessException {
		userRepository.save(user);
	}
	
	 
    /* Grupos */
    @Override
    @Transactional(readOnly = true)
    public Collection<Grupo> findGrupos() throws DataAccessException {
    	return grupoRepository.findAll();
    }
	 
    @Override
    @Transactional(readOnly = true)
    public Grupo findGrupoById(int id) throws DataAccessException {
    	return grupoRepository.findGrupoById(id);
    }
	 
    @Override
    @Transactional
    public void saveGrupo(Grupo grupo) throws DataAccessException {
    	grupoRepository.save(grupo);
    }
	 
    @Override
    public void deleteGrupo(int grupoId) throws DataAccessException {
    	grupoRepository.delete(grupoId);
    }

	@Override
	public Collection<Grupo> findGrupoByName(String name) throws DataAccessException {
		return grupoRepository.findByName(name);
	}

	@Override
	public Grupo findByGroupName(String name) throws DataAccessException {
		return grupoRepository.findByGroupNameC(name);
	}

	
    /* Resultados */
	@Override
	public Collection<Resultado> findResultados() {
		 return resultadoRepository.findAll();
	}
	
    @Override
    @Transactional(readOnly = true)
    public Resultado findResultadoById(int id) throws DataAccessException {
    	return resultadoRepository.findById(id);
    }


	@Override
	public void saveResultado(Resultado resultado) throws DataAccessException {
		resultadoRepository.save(resultado);
	}
	
	@Override
    public void deleteResultado(int resultadoId) throws DataAccessException {
		resultadoRepository.delete(resultadoId);
    }
	
	/* Tests */
	@Override
	public Collection<Test> findTests() {
		 return testRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Test findTestById(int testId) throws DataAccessException {
		 return testRepository.findById(testId);
	}
	
	
	/* Valores */
	@Override
	public void saveValor(Valores value) {
		valoresRepository.save(value);
	}

	@Override
	public void saveAlumno(Alumno alumno) {
		alumnoRepository.save(alumno);
	}

	@Override
	public ArrayList<Integer> findAlumnosIdByTest(String testName) throws DataAccessException {
		return alumnoRepository.findByIdAlumnoTest(testName);
	}

	@Override
	public void deleteAlumno(int id) {
		alumnoRepository.delete(id);
		
	}

	@Override
	public void deleteUser(int id) {
		userRepository.delete(id);
		
	}

	@Override
	public void saveResForm(Res_formulario resFormulario) {
		// TODO Auto-generated method stub
		fichaFormRepository.save(resFormulario);
	}

}
