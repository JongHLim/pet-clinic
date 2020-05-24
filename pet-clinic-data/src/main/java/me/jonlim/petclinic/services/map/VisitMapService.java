package me.jonlim.petclinic.services.map;

import me.jonlim.petclinic.model.Visit;
import me.jonlim.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
  @Override
  public Set<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public Visit findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Visit save(Visit visit) {
    if (visit.getPet() == null) {
      throw new RuntimeException("Could not retrieve pet");
    }
    if (visit.getPet().getId() == null) {
      throw new RuntimeException("Could not retrieve pet ID");
    }
    if (visit.getPet().getOwner() == null) {
      throw new RuntimeException(("Could not retrieve owner"));
    }
    return super.save(visit);
  }

  @Override
  public void delete(Visit object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
