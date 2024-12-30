using Microsoft.EntityFrameworkCore;
using AA_Backend.Models;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;


namespace AA_Backend.Data
{
    public class AA_BackendContext : IdentityDbContext<User>
    {
        public AA_BackendContext (DbContextOptions<AA_BackendContext> options) : base(options){}

        public DbSet<Character> Character { get; set; } = default!;
    }
}
