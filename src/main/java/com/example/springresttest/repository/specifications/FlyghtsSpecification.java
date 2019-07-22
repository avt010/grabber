package com.example.springresttest.repository.specifications;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.springresttest.entity.Flyghts;

public class FlyghtsSpecification {

    public static Specification<Flyghts> flyghtsByName(final HashMap<String, Object> filter) {
        return new Specification<Flyghts>() {
            
        	private static final long serialVersionUID = 1L;

			@Override
            public Predicate toPredicate(Root<Flyghts> root,
                    CriteriaQuery<?> criteriaQuery,
                    CriteriaBuilder criteriaBuilder) {
            	Predicate predicate = criteriaBuilder.conjunction();
            	Iterator<Entry<String, Object>> it = filter.entrySet().iterator();
                while (it.hasNext()) {
                	Map.Entry<String, Object> pair = (Map.Entry<String, Object>)it.next();
                	String field = (String)pair.getKey();
                    Object value = pair.getValue();
                    predicate.getExpressions().add(criteriaBuilder.equal(root.get(field), value));
                }
                return predicate;
                //return criteriaBuilder.equal(root.get("owner").get("lastName"), lastName);
            }
        };
    }
}