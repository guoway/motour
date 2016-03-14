package club.motour.dao.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.ImageDAO;
import club.motour.model.Image;

@Repository
public class ImageDAOImpl extends SpringHibernateDAO<Image, BigDecimal> implements ImageDAO {
}
