package com.nt.service;

import java.util.List;

import com.nt.entity.ActorInfo;

public interface IActorInfoMgmtService 
{
	public ActorInfo register(ActorInfo actor);
	public List<ActorInfo> getAllActors();
	public String deleteActorInfo(int actorId);
	public ActorInfo findActorInfoByInfo(int actorId);
	public ActorInfo updateActor(ActorInfo actor);
}
