using Microsoft.EntityFrameworkCore;
using AA_Backend.Models;

namespace AA_Backend.Data
{
    public class AA_BackendContext : DbContext
    {
        public AA_BackendContext (DbContextOptions<AA_BackendContext> options)
            : base(options)
        {
        }

        public DbSet<Character> Character { get; set; } = default!;
    }
}
