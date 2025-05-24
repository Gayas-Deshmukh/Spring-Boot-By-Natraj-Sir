package com.nt.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import com.nt.entity.ActorInfo;
import com.nt.repo.ActorRepo;


@Service
public class ActorInfoMgmtServiceImpl implements IActorInfoMgmtService
{
	@Autowired
	private ActorRepo actorRepo;
	
	@Override
    @CacheEvict(value = "allActors", allEntries = true) // Add actor and clear allActors cache
	public ActorInfo register(ActorInfo actor)
	{
		ActorInfo savedActor = actorRepo.save(actor);
		return savedActor;
	}

	@Override
	@Cacheable(value = "allActors") //Cache all actors
	public List<ActorInfo> getAllActors()
	{
		return actorRepo.findAll();
	}

	@Override
    @Cacheable(value = "actor", key = "#actorId") // Cache actor by ID
	public ActorInfo findActorInfoByInfo(int actorId)
	{
		return actorRepo.findById(actorId).orElseThrow(()-> new IllegalArgumentException("Invalid Actor Id"));
	}

   // @CachePut(value = "actor", key = "#actor.id") // Update actor and refresh cache
	@Caching(
		    put = {
		        @CachePut(value = "actor", key = "#actor.id") // Update actor and refresh cache
		    },
		    evict = {
		        @CacheEvict(value = "allActors", allEntries = true) // clear the list cache
		    }
		)
	@Override
	public ActorInfo updateActor(ActorInfo actor)
	{
		ActorInfo savedActor = actorRepo.save(actor);
		return savedActor;
	}

	@Override
   // @CacheEvict(value = "actor", key = "#actorId")// Delete actor and evict actor cache by ID
	@Caching(evict = {
		    @CacheEvict(value = "actor", key = "#actorId"),          // remove individual actor
		    @CacheEvict(value = "allActors", allEntries = true) // clear full list
		})
	public String deleteActorInfo(int actorId)
	{
		Optional<ActorInfo>	optional	=	actorRepo.findById(actorId);
		
		if (optional.isPresent())
		{
			actorRepo.deleteById(actorId);
			
			return "Product is found & deleted";
		}
		
		return "Product is not found for deletion";
	}
}
