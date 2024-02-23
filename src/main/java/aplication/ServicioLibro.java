package aplication;

import java.util.ArrayList;
import java.util.List;

import aplication.dto.LibroDTO;
import domain.model.AbsCRUD;
import domain.model.LibroModel;

public class ServicioLibro extends ServicioCRUD<LibroDTO> {

	private AbsCRUD<Libro> modelo;
	private ServicioCRUD<Autor> sAutor;
	private ServicioCRUD<Categoria> sCategoria;

	public ServicioLibro() {
		this.modelo = new LibroModel();
		this.sAutor = new ServicioAutor();
		this.sCategoria = new ServicioCategoria();
	}

	public Libro libroDTOALibro(LibroDTO dto) {
		Libro libro = new Libro();
		List<Autor> autores = new ArrayList<Autor>();

		dto.setAutoresIDs((obtenerIdAutores(dto)));
		for (Autor autorEncontrado : sAutor.lista()) {
			for (Integer idAutorEncontrado : dto.getAutoresIDs()) {
				if (idAutorEncontrado == autorEncontrado.getID()) {
					autores.add(autorEncontrado);
				}
			}
		}
		Categoria categoriaEncontrada = sCategoria.consultar(dto.getCategoriaID());
		if (autores.isEmpty() || categoriaEncontrada == null) {
			throw new IllegalArgumentException("Sin autores o Categoria");
		}
		libro.setAutores(autores);
		libro.setCategoria(categoriaEncontrada);
		libro.setDescripcion(dto.getDescripcion());
		libro.setEditorial(dto.getEditorial());
		libro.setEstado(dto.getEstado());
		libro.setID(dto.getID());
		libro.setISSN(dto.getISSN());
		libro.setNroIngreso(dto.getNroIngreso());
		libro.setTitulo(dto.getTitulo());
		return libro;
	}

	public LibroDTO libroALibroDTO(Libro libro) {
		LibroDTO libroDTO = new LibroDTO();
		libroDTO.setID(libro.getID());
		libroDTO.setCategoriaID(libro.getCategoria().getID());
		List<Integer> autoresIDs = new ArrayList<>();
		for (Autor autor : libro.getAutores()) {
			autoresIDs.add(autor.getID());
		}
		libroDTO.setAutoresIDs(autoresIDs);
		libroDTO.setTitulo(libro.getTitulo());
		libroDTO.setEstado(libro.getEstado());
		libroDTO.setNroIngreso(libro.getNroIngreso());
		libroDTO.setEditorial(libro.getEditorial());
		libroDTO.setISSN(libro.getISSN());
		libroDTO.setDescripcion(libro.getDescripcion());

		StringBuilder autoresString = new StringBuilder();
		for (Integer idAutor : autoresIDs) {
			autoresString.append(idAutor).append(", ");
		}
		if (autoresString.length() > 0) {
			autoresString.delete(autoresString.length() - 2, autoresString.length());
		}
		libroDTO.setAutoresString(autoresString.toString());
		return libroDTO;
	}

	private List<Integer> obtenerIdAutores(LibroDTO libroDTO) {
		List<Integer> idAutores = new ArrayList<>();
		String[] autoresStrings = libroDTO.getAutoresString().split("[,;\\s]+");
		for (String idAutor : autoresStrings) {
			int id = Integer.parseInt(idAutor.replaceAll("\\s+", ""));
			idAutores.add(id);
		}
		return idAutores;
	}

	@Override
	public List<LibroDTO> lista() {
		List<Libro> libros = modelo.lista();
		List<LibroDTO> librosDTO = new ArrayList<LibroDTO>();
		for (Libro libro : libros) {
			LibroDTO libroDTO = libroALibroDTO(libro);
			librosDTO.add(libroDTO);
		}
		return librosDTO;
	}

	@Override
	public LibroDTO crear(LibroDTO obj) {
		System.out.println(obj.toString());
		Libro libro = libroDTOALibro(obj);
		System.out.println(libro.toString());
		modelo.crear(libro);
		return obj;
	}

	@Override
	public LibroDTO consultar(int ID) {
		Libro libro = modelo.consultar(ID);
		LibroDTO aDto = libroALibroDTO(libro);
		return aDto;
	}

	@Override
	public LibroDTO modificar(LibroDTO obj) {
		Libro libro = libroDTOALibro(obj);
		modelo.modificar(libro);
		return obj;
	}

	@Override
	public void eliminar(LibroDTO obj) {
		Libro libro = libroDTOALibro(obj);
		modelo.eliminar(libro);
	}

}
