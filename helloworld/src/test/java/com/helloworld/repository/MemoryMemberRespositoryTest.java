package com.helloworld.repository;

import com.helloworld.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRespositoryTest {

    MemoryMemberRespository respository = new MemoryMemberRespository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        respository.save(member);

        Member result = respository.findById(member.getId()).get();
        //System.out.println("result = " + (result == member));
        //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }
}
