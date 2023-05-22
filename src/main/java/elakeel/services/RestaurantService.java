package elakeel.services;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import elakeel.ejbs.Order;
import elakeel.ejbs.OrderStatus;
import elakeel.ejbs.Restaurant;
import elakeel.ejbs.RestaurantReport;
