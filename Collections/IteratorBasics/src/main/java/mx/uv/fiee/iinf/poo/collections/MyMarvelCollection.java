package mx.uv.fiee.iinf.poo.collections;

import java.util.NoSuchElementException;

public class MyMarvelCollection {
    private final Film [] films;
    private int index;
    public MyMarvelCollection (Film [] films) {
        this.films = films;
        this.index = 0;
    }

    public void add (Film film) {
        if (index >= films.length) {
            throw new ArrayIndexOutOfBoundsException ();
        }

        films [index] = film;
        index++;
    }

    public Film get (int index) {
        if (index >= films.length) {
            throw new ArrayIndexOutOfBoundsException ();
        }

        var film = films [index];
        if (film == null) {
            throw new NoSuchElementException ();
        }

        return film;
    }

    public int size () {
        return films.length;
    }

}

