package hello.hellospring.repository;

import hello.hellospring.Domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository respository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        respository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        Member member2 = new Member();
        member2.setName("spring2");

        respository.save(member2);
        Member result = respository.findById(member2.getId()).get();

        assertThat(member2).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Spring3");
        respository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring4");
        respository.save(member2);

        Member result = respository.findByName("Spring3").get();
        Member result2 = respository.findByName("Spring4").get();

        assertThat(result).isEqualTo(member1);
        assertThat(result2).isEqualTo(member2);
    }

}
