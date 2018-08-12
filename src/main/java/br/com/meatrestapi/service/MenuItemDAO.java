package br.com.meatrestapi.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meatrestapi.model.MenuItem;

@Repository
public class MenuItemDAO extends AbstractDAO<MenuItem, String> {
	public void load(List<MenuItem> lItem) {
		for (MenuItem m : lItem) {
			save(m);
		}
	}

}
