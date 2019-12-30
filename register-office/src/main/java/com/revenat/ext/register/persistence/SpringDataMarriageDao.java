package com.revenat.ext.register.persistence;

import com.revenat.ext.register.business.MarriageDao;
import com.revenat.ext.register.business.entity.MarriageCertificate;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

/**
 * @author Vitaliy Dragun
 */
@RepositoryDefinition(domainClass = MarriageCertificate.class, idClass = Long.class)
@Repository("springMarriageDao")
public interface SpringDataMarriageDao extends MarriageDao {
}
