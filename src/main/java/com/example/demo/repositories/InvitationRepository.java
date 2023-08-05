package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Invitation;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long>{

}
